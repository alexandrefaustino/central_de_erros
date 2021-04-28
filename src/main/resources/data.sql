INSERT INTO `user`
(id, name, email, password, status)
VALUES
(9, 'Julio', 'juliokauer@gmail.com', '123456', true);
(8, 'Alexandre', 'alexandre@gmail.com', '123456', true);
(7, 'Emanuelle', 'emanuelle@gmail.com', '123456', true);

INSERT INTO `log_error`
(id, level, description, origin, event_log, date)
VALUES
(1, 'INFO', 'erro de informação', '192.168.1.1', 'cadastrarError()', '2021-04-12'),
(2, 'WARNING', 'Dados inválidos', '192.168.1.2', 'buscarErro()', '2021-04-12'),
(3, 'ERROR', 'erro de informação', '192.168.1.3', 'listarEventos()', '2021-04-13'),
(4, 'INFO', 'erro caótico', '192.168.1.4', 'cadastrarError()', '2021-04-11'),
(5, 'WARNING', 'erro de informação', '192.168.1.4', 'buscarErro()', '2021-04-08'),
(6, 'ERROR', 'Not found', '192.168.1.4', 'cadastrarError()', '2021-04-08'),
(7, 'ERROR', 'buscar erro', '192.168.1.3', 'cadastrarError()', '2021-04-11'),
(8, 'WARNING', 'alerta vermelho', '192.168.1.2', 'listarEventos()', '2021-04-11'),
(9, 'INFO', 'erro de informação', '192.168.1.1', 'cadastrarError()', '2021-04-13');

