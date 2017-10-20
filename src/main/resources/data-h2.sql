INSERT INTO parent (id) VALUES
  (1),
  (2),
  (3),
  (4)
;

INSERT INTO one_to_one_child (id, parent_id, val) VALUES
  (100,  1, 42),
  (101, 2, 43),
  (102, 3, 44)
;
