for (let i=0; i < 100000; i++) {
    let l = []
    for (let j=0; j<100; j++) {
        l.push(Math.floor(Math.random()*1000000))
    }
    db.dataArrayDocument.insertOne({ "l" : l })
}
