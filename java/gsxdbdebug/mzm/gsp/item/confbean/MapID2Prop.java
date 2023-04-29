/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MapID2Prop implements Marshal
/*    */ {
/*    */   public int mapId;
/*    */   public int mapProp;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/* 15 */     this.mapProp = Integer.valueOf(rootElement.attributeValue("mapProp")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.mapId);
/* 21 */     _os_.marshal(this.mapProp);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.mapId = _os_.unmarshal_int();
/* 28 */     this.mapProp = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\MapID2Prop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */