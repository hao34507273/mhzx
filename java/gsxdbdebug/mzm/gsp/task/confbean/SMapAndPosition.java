/*    */ package mzm.gsp.task.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SMapAndPosition implements Marshal
/*    */ {
/*    */   public int mapId;
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/* 16 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/* 17 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.mapId);
/* 23 */     _os_.marshal(this.x);
/* 24 */     _os_.marshal(this.y);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.mapId = _os_.unmarshal_int();
/* 31 */     this.x = _os_.unmarshal_int();
/* 32 */     this.y = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\SMapAndPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */