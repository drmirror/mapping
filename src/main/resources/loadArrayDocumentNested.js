for (let i=0; i < 100000; i++) {
    let l = []
    for (let j=0; j<100; j++) {
        l.push({ "a" : Math.floor(Math.random()*1000000) })
    }
    db.dataArrayDocumentNested.insertOne({ "l" : l })
}
