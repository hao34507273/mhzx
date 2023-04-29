/*    */ package mzm.gsp.map.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class CellSegment implements Marshal
/*    */ {
/*    */   public int beginIndex;
/*    */   public int endIndex;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.beginIndex = Integer.valueOf(rootElement.attributeValue("beginIndex")).intValue();
/* 15 */     this.endIndex = Integer.valueOf(rootElement.attributeValue("endIndex")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.beginIndex);
/* 21 */     _os_.marshal(this.endIndex);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.beginIndex = _os_.unmarshal_int();
/* 28 */     this.endIndex = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\CellSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */