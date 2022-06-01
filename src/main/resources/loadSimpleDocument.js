for (let i=0; i < 100000; i++) {
    db.dataSimpleDocument.insertOne({ "a" : Math.floor(Math.random()*1000000) })
}

