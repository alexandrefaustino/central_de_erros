INSERT INTO `user`
(id, name, email, password, status)
VALUES
(9, 'Julio', 'juliokauer@gmail.com', '123456', true);

INSERT INTO `log_error`
(id, level, description, origin, event_log, details, date)
VALUES
(1, 'INFO', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-10'),
(2, 'WARNING', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-12'),
(3, 'ERROR', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-13'),
(4, 'INFO', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-11'),
(5, 'WARNING', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-09'),
(6, 'ERROR', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-08'),
(7, 'ERROR', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-13'),
(8, 'WARNING', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-01'),
(9, 'INFO', 'erro de informação', '192.168.1.5', 'cadastrarError()', 'sem maiores detalhes', '2021-04-13');

