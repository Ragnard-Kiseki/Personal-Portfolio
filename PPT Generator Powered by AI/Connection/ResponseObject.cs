namespace PPTGenerator
{
    public class ResponseObject
    {
        public string? response_id { get; set; }
        public string? text { get; set; }
        public string? generation_id { get; set; }
        public TokenCount? token_count { get; set; }
        public Meta? meta { get; set; }
        public object? tool_inputs { get; set; }
    }

    public class TokenCount
    {
        public int prompt_tokens { get; set; }
        public int response_tokens { get; set; }
        public int total_tokens { get; set; }
        public int billed_tokens { get; set; }
    }

    public class Meta
    {
        public ApiVersion? api_version { get; set; }
        public BilledUnits? billed_units { get; set; }
    }

    public class ApiVersion
    {
        public string? version { get; set; }
    }

    public class BilledUnits
    {
        public int input_tokens { get; set; }
        public int output_tokens { get; set; }
    }
}