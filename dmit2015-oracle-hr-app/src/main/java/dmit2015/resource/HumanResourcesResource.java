package dmit2015.resource;

import dmit2015.dto.EmployeeDto;
import dmit2015.dto.JobDto;
import dmit2015.dto.RegionDto;
import dmit2015.entity.Job;
import dmit2015.entity.Region;
import dmit2015.mapper.EmployeeMapper;
import dmit2015.mapper.JobMapper;
import dmit2015.mapper.RegionMapper;
import dmit2015.persistence.HumanResourcesRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/hr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HumanResourcesResource {

    @Inject
    private HumanResourcesRepository hrRepository;

    @GET
    @Path("/Regions")
    public List<RegionDto> getRegions() {
        return  hrRepository
                .getRegions()
                .stream()
                .map(RegionMapper.INSTANCE::toDto)
                .toList();
    }

    @GET
    @Path("/jobs")
    public List<JobDto> getJobs() {
        return  hrRepository
                .getJobs()
                .stream()
                .map(JobMapper.INSTANCE::toDto)
                .toList();
    }

    @GET
    @Path("/Employees")
    public List<EmployeeDto> getEmployees() {
        return  hrRepository
                .getEmployees()
                .stream()
                .map(EmployeeMapper.INSTANCE::toDto)
                .toList();
    }
}
