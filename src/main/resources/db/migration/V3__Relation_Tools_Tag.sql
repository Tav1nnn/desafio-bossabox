CREATE TABLE tag_tools (
    tag_id INTEGER NOT NULL REFERENCES tag(id),
    tool_id INTEGER NOT NULL REFERENCES tools(id),
    PRIMARY KEY (tag_id, tool_id)
);