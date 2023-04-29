/*    */ package mzm.gsp.singlebattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BuffInfo implements Marshal
/*    */ {
/*    */   public int buff_info_cfg_id;
/*    */   public int x;
/*    */   public int y;
/*    */   public int radius;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.buff_info_cfg_id = Integer.valueOf(rootElement.attributeValue("buff_info_cfg_id")).intValue();
/* 17 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/* 18 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/* 19 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.buff_info_cfg_id);
/* 25 */     _os_.marshal(this.x);
/* 26 */     _os_.marshal(this.y);
/* 27 */     _os_.marshal(this.radius);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.buff_info_cfg_id = _os_.unmarshal_int();
/* 34 */     this.x = _os_.unmarshal_int();
/* 35 */     this.y = _os_.unmarshal_int();
/* 36 */     this.radius = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\confbean\BuffInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */