let crypto = require("crypto")
for (let i=0; i<100000; i++) {
    let d = {}
    for (let j=100; j<200; j++) {
        let k = "a" + j;
        d[k] = crypto.randomBytes(10).toString("hex")
    }
    db.dataManyFieldsDocumentString.insertOne(d)
}
