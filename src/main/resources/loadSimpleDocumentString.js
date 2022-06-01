let crypto = require("crypto")
for (let i=0; i < 100000; i++) {
    db.dataSimpleDocumentString.insertOne({ "a" : crypto.randomBytes(10).toString("hex") })
}
