INSERT INTO `user` (`user_id`, `uid`, `upw`, `nick_name`, `pic`, `created_at`, `updated_at`, `provider_type`) VALUES (1, 'mic', '$2a$10$cVRpfytmEdzvs1I4oqqRXOWUleJHm6xKjOnHqA3EEJ5.Q0cAtbhte', '홍길동', NULL, '2024-11-01 10:10:01', '2024-11-01 10:10:01', '01'), (2, 'jacob', '$2a$10$cVRpfytmEdzvs1I4oqqRXOWUleJHm6xKjOnHqA3EEJ5.Q0cAtbhte', '제이콥', NULL, '2024-11-01 10:10:02', '2024-11-01 10:10:02', '01');

INSERT INTO `feed` (`feed_id`, `created_at`, `updated_at`, `contents`, `location`, `writer_user_id`) VALUES (1, '2025-03-11 11:34:22.021496', '2025-03-11 11:34:22.021496', '테스트 글 1', '테스트 위치 1', 1), (2, '2025-03-11 11:34:22.021496', '2025-03-11 11:34:22.021496', '테스트 글 2', '테스트 위치 2', 2);

