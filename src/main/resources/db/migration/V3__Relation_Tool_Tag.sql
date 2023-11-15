CREATE TABLE tag_tool (
    tag_id INTEGER NOT NULL REFERENCES tag(id),
    tool_id INTEGER NOT NULL REFERENCES tool(id),
    PRIMARY KEY (tag_id, tool_id)
);