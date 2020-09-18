INSERT INTO POST (post_id, title, body, create_date)
VALUES (1, 'Title 1',
        '"POST 1"',
        {ts '2020-07-19 01:10:13.247'});
INSERT INTO POST (post_id, title, body, create_date)
VALUES (2, 'Title 2',
        '"POST 2"',
        --         CURRENT_TIMESTAMP());
        {ts '2016-11-10 11:10:13.247'});
INSERT INTO POST (post_id, title, body, create_date)
VALUES (3, 'Title 3',
        '"POST 1"',
        CURRENT_TIMESTAMP());
INSERT INTO POST (post_id, title, body, create_date)
VALUES (4, 'Title 4',
        '"POST 4"',
        {ts '2020-08-19 01:10:13.247'});
INSERT INTO POST (post_id, title, body, create_date)
VALUES (5, 'Title 5',
        '"POST 5"',
        --         CURRENT_TIMESTAMP());
        {ts '2018-11-10 11:10:13.247'});
INSERT INTO POST (post_id, title, body, create_date)
VALUES (6, 'Title 6',
        '"POST 6"',
        CURRENT_TIMESTAMP());
INSERT INTO POST (post_id, title, body, create_date)
VALUES (7, 'Title 7',
        '"POST 7"',
        CURRENT_TIMESTAMP());
INSERT INTO POST (post_id, title, body, create_date)
VALUES (8, 'Title 8',
        '"POST 8"',
        CURRENT_TIMESTAMP());
INSERT INTO POST (post_id, title, body, create_date)
VALUES (9, 'Title 9',
        '"POST 9"',
        CURRENT_TIMESTAMP());
INSERT INTO POST (post_id, title, body, create_date)
VALUES (10, 'Title 10',
        '"POST 10"',
        CURRENT_TIMESTAMP());

-- Comments
INSERT INTO COMMENT (comment_id, post_id, body, create_date)
VALUES (1, 1,
        '"POST 1 - COMMENT 1"',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id, post_id, body, create_date)
VALUES (2, 1,
        '"POST 1 - COMMENT 2"',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id, post_id, body, create_date)
VALUES (3, 1,
        '"POST 1 - COMMENT 3"',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id, post_id, body, create_date)
VALUES (4, 6,
        '"POST 6 - COMMENT 4"',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id, post_id, body, create_date)
VALUES (5, 6,
        '"POST 6 - COMMENT 5"',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id, post_id, body, create_date)
VALUES (6, 6,
        '"POST 6 - COMMENT 6"',
        CURRENT_TIMESTAMP());