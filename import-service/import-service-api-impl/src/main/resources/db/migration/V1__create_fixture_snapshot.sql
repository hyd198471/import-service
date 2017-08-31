DROP TABLE IF EXISTS `fixture_snapshot`;
create table fixture_snapshot (
    id BIGINT(20),
    ebet_json MEDIUMTEXT,
    version BIGINT(20) UNSIGNED,
    update_time TIMESTAMP,
    published_at TIMESTAMP(3),
    published BOOLEAN,
    bg_header_timestamp TIMESTAMP(3),
    section_number TINYINT,
    PRIMARY KEY (id)
);

