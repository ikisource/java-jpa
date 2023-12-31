package fr.ikisource.oma.javajpa.service; /**
 * Copyright (c) 2015-2019 AriadNEXT - All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of
 * AriadNEXT and its suppliers, if any. The intellectual and technical concepts
 * contained herein are proprietary to AriadNEXT and its suppliers and may be
 * covered by U.E. and Foreign Patents, patents in process, and are protected
 * by trade secret or copyright law. Dissemination of this information or
 * reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from AriadNEXT.
 */

import fr.ikisource.oma.javajpa.model.Author;
import fr.ikisource.oma.javajpa.model.Country;
import fr.ikisource.oma.javajpa.repository.AuthorRepository;
import fr.ikisource.oma.javajpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataManager {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    AuthorRepository authorRepository;

    public void cleanDatabase() {

        authorRepository.deleteAll();
        countryRepository.deleteAll();
    }

    public Author createAuthor(Country country) {
        Author author = new Author(country, "name1");
        return authorRepository.save(author);
    }

    public Country createCountry() {
        Country country = new Country("name1");
        return countryRepository.save(country);
    }

    /*public List<Realm> createRealms(int start, int end) {

        List<Realm> realms = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            realms.add(realmRepository.save(new Realm("realm" + i, "realm description" + i)));
        }
        return realms;
    }

    public NotificationEndpoint createNotificationEndpoint() {

        Realm realm = createRealm();

        return notificationEndpointRepository.save(new NotificationEndpoint(realm, "clientId", "http://idnow.io", new Header("header-name", "header-value"), "secret", true, "supportEmail"));
    }

    public NotificationEndpoint createNotificationEndpoint(Realm realm) {

        return notificationEndpointRepository.save(new NotificationEndpoint(realm, "clientId","http://idnow.io", new Header("header-name", "header-value"), "secret", true, "supportEmail"));
    }

    public List<NotificationEndpoint> createNotificationEndpoints(Realm realm, int start, int end) {
        List<NotificationEndpoint> notificationEndpoints = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            notificationEndpoints.add(notificationEndpointRepository.save(new NotificationEndpoint(realm, "clientId" + i,"http://idnow.io" + i, new Header("header-name" + i, "header-value" + i), "secret" + i, true, "supportEmail" + i)));
        }
        return notificationEndpoints;
    }

    public NotificationEvent createNotificationEvent() {

        NotificationEndpoint notificationEndpoint = createNotificationEndpoint();

        return notificationEventRepository.save(new NotificationEvent(notificationEndpoint, EnumNotificationEventKindBean.DOCUMENT, EnumNotificationEventMethodBean.CREATE, EnumNotificationEventOperationBean.ADD_DOCUMENT));
    }

    public NotificationEvent createNotificationEvent(NotificationEndpoint notificationEndpoint) {

        return notificationEventRepository.save(new NotificationEvent(notificationEndpoint, EnumNotificationEventKindBean.DOCUMENT, EnumNotificationEventMethodBean.CREATE, EnumNotificationEventOperationBean.ADD_DOCUMENT));
    }

    public NotificationEvent createNotificationEvent(EnumNotificationEventKindBean kind, EnumNotificationEventMethodBean method, EnumNotificationEventOperationBean operation) {

        NotificationEndpoint notificationEndpoint = createNotificationEndpoint();

        return notificationEventRepository.save(new NotificationEvent(notificationEndpoint, kind, method, operation));
    }

    public NotificationEvent createNotificationEvent(NotificationEndpoint notificationEndpoint, EnumNotificationEventKindBean kind, EnumNotificationEventMethodBean method, EnumNotificationEventOperationBean operation) {

        return notificationEventRepository.save(new NotificationEvent(notificationEndpoint, kind, method, operation));
    }

     */
}
