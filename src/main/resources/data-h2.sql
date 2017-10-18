INSERT INTO parent (id) VALUES
  (1),
  (2),
  (3),
  (4)
;

INSERT INTO one_to_one_child (id, parent_id, name) VALUES
  (9,  1, 'one-to-one child 1'),
  (10, 2, 'one-to-one child 2'),
  (11, 3, 'one-to-one child 3')
;

INSERT INTO one_to_one_child2 (id, parent_id, name) VALUES
  (90,  1, 'one-to-one child2 1'),
  (91, 2, 'one-to-one child2 2'),
  (92, 3, 'one-to-one child2 3')
;
