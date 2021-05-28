FROM httpd:2.4-alpine
COPY ./server.crt /usr/local/apache2/conf/server.crt
COPY ./server.key /usr/local/apache2/conf/server.key
COPY ./asi-reverse-proxy.conf /usr/local/apache2/conf/httpd.conf