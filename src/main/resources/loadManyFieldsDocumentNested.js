for (let i=0; i<100000; i++) {
    let d = {}
    for (let j=100; j<200; j++) {
        let k = "a" + j;
        d[k] = { "a" : Math.floor(Math.random()*1000000) }
    }
    db.dataManyFieldsDocumentNested.insertOne(d)
}
