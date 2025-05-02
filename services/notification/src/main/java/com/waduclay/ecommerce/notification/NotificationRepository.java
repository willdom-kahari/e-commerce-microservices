package com.waduclay.ecommerce.notification;


import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public interface NotificationRepository extends MongoRepository<Notification, String> {
}
