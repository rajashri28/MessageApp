package com.example.teslaind1.messageapp.realm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Teslaind 1 on 12/3/2017.
 */

public class Migration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
       if (oldVersion == 2) {
            // Migrate from v0 to v1

            schema.get("SmsModel")
                    .addField("messageId", Integer.class);// example

            oldVersion++;
        }


    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Migration);
    }
}
