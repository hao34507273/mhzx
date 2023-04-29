/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SelectionStageTimeBean implements Marshal
/*    */ {
/*    */   public int selection_stage;
/*    */   public int selection_time_point_cfg_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.selection_stage = Integer.valueOf(rootElement.attributeValue("selection_stage")).intValue();
/* 15 */     this.selection_time_point_cfg_id = Integer.valueOf(rootElement.attributeValue("selection_time_point_cfg_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.selection_stage);
/* 21 */     _os_.marshal(this.selection_time_point_cfg_id);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.selection_stage = _os_.unmarshal_int();
/* 28 */     this.selection_time_point_cfg_id = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SelectionStageTimeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */