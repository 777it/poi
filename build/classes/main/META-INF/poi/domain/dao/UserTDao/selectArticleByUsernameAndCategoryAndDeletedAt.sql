select
  /*%expand*/*
from
  article_t
where
  username = /* username */'poi' and
  category = /* category */'poi' and
  deleted_at is null