package cn.microvideo.framework3.project.mapper;

import cn.microvideo.framework3.project.entity.Camera;
import cn.microvideo.framework3.project.entity.CameraType;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CameraMapper {
    List<Camera> selectByLineId(Integer LineId);

    Camera selectByCameraId(Integer cameraId);

    List<Camera> selectAll();

    int deleteByCameraId(Integer cameraId);

    int insertCamera(Camera camera);

    int updateCamera(Camera camera);

    List<CameraType> selectAllCameraType();
}