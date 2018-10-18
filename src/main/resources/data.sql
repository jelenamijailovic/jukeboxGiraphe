insert into node (id,node_type,properties) 
  values ('99df692f9caa43c2b67f06a582077188','Artist','{"name": "EKV"}'),
  		 ('99df692f9caa43c2b67f06a582077189','Song','{"name": "Srce"}'),
  		 ('99df692f9caa43c2b67f06a582077190','Price','{"price": 100}'),
  		 ('99df692f9caa43c2b67f06a582077191','Traffic','{"date": ""}');
  
insert into node (id,node_type,properties)
  values ('f4c416a409d84b408c3e650a765cd71c','Genre','{"name": "Rock"}');
  
insert into edge (id,edge_type,from_node_id,to_node_id,properties)
  values ('50e81e19f0574ea6aca1a4e7defad8b3','contains','f4c416a409d84b408c3e650a765cd71c','99df692f9caa43c2b67f06a582077188','{}'),
  		 ('50e81e19f0574ea6aca1a4e7defad8b4','relates','99df692f9caa43c2b67f06a582077190','99df692f9caa43c2b67f06a582077189','{}'),
  		 ('50e81e19f0574ea6aca1a4e7defad8b5','sings','99df692f9caa43c2b67f06a582077188','99df692f9caa43c2b67f06a582077189','{}'),
  		 ('50e81e19f0574ea6aca1a4e7defad8b6','placed','99df692f9caa43c2b67f06a582077189','99df692f9caa43c2b67f06a582077191','{}');