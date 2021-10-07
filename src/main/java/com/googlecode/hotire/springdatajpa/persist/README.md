# Persist

## SessionImpl

save 할 경우, PersistEvent와 같은 이벤트를 발생시킨다. 

## DefaultPersistEventListener 

onPersist 이벤트가 발생하면 처리한다. 

흐름을 따라가다보면 loadFromDatasource 안에서 persister.load를 한다. 

### AbstractEntityPersister

### Loader

prepareQueryStatement 