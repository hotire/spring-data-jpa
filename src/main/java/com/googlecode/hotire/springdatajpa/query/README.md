# Query

## prepared statement

### CriteriaCompiler

~~~java
public QueryImplementor compile(CompilableCriteria criteria) {
	return criteria.interpret( renderingContext ).buildCompiledQuery(
				entityManager,
				new InterpretedParameterMetadata() {
					@Override
					public Map<ParameterExpression<?>, ExplicitParameterInfo<?>> explicitParameterInfoMap() {
						return explicitParameterInfoMap;
					}

					@Override
					public List<ImplicitParameterBinding> implicitParameterBindings() {
						return implicitParameterBindings;
					}
				}
		);
}
~~~

### CriteriaQueryImpl
~~~java
	@Override
	public CriteriaInterpretation interpret(RenderingContext renderingContext) {
		final StringBuilder jpaqlBuffer = new StringBuilder();

		queryStructure.render( jpaqlBuffer, renderingContext );
    ....
}
~~~


### QueryStructure

~~~java
	public void render(StringBuilder jpaqlQuery, RenderingContext renderingContext) {
		renderSelectClause( jpaqlQuery, renderingContext );

		renderFromClause( jpaqlQuery, renderingContext );

		renderWhereClause( jpaqlQuery, renderingContext );

		renderGroupByClause( jpaqlQuery, renderingContext );
	}
~~~

~~~java
protected void renderWhereClause(StringBuilder jpaqlQuery, RenderingContext renderingContext) {
		if ( getRestriction() == null ) {
			return;
		}

		renderingContext.getClauseStack().push( Clause.WHERE );
		try {
			jpaqlQuery.append( " where " )
					.append( ( (Renderable) getRestriction() ).render( renderingContext ) );
		}
		finally {
			renderingContext.getClauseStack().pop();
		}
	}
~~~


### CompoundPredicate

~~~java
    @Override
	public String render(RenderingContext renderingContext) {
		return render( isNegated(), renderingContext );
	}
~~~

### ComparisonPredicate
~~~java
	@Override
	public String render(boolean isNegated, RenderingContext renderingContext) {
		return ( (Renderable) getLeftHandOperand() ).render( renderingContext )
				+ getComparisonOperator( isNegated ).rendered()
				+ ( (Renderable) getRightHandOperand() ).render( renderingContext );
	}
~~~

### LiteralExpression
~~~java
	@Override
	public String render(RenderingContext renderingContext) {
		// In the case of literals, we currently do not have an easy way to get the value.
		// That would require some significant infrastructure changes.
		// For now, we force the normalRender() code path for enums which means we will
		// always use parameter binding for enum literals.
		if ( literal instanceof Enum ) {
			return normalRender( renderingContext, LiteralHandlingMode.BIND );
		}

		switch ( renderingContext.getClauseStack().getCurrent() ) {
			case SELECT: {
				return renderProjection( renderingContext );
			}
			case GROUP: {
				// technically a literal in the group-by clause
				// would be a reference to the position of a selection
				//
				// but this is what the code used to do...
				return renderProjection( renderingContext );
			}
			default: {
				return normalRender( renderingContext, renderingContext.getCriteriaLiteralHandlingMode() );
			}
		}
	}
~~~

~~~java
	private String normalRender(RenderingContext renderingContext, LiteralHandlingMode literalHandlingMode) {
		switch ( literalHandlingMode ) {
			case AUTO: {
				if ( ValueHandlerFactory.isNumeric( literal ) ) {
					return ValueHandlerFactory.determineAppropriateHandler( (Class) literal.getClass() ).render( literal );
				}
				else {
					return bindLiteral( renderingContext );
				}
			}
			case BIND: {
				return bindLiteral( renderingContext );
			}
~~~


### Why Hibernate inlines Integer parameter list passed to JPA Criteria Query?

- https://stackoverflow.com/questions/36811521/why-hibernate-inlines-integer-parameter-list-passed-to-jpa-criteria-query


### jpa-query-parameters 
- https://www.baeldung.com/jpa-query-parameters
