/*    */ package mzm.gsp.qiuqian.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SQianWenInfo implements Marshal
/*    */ {
/*    */   public int sort_id;
/*    */   public int point;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/* 15 */     this.point = Integer.valueOf(rootElement.attributeValue("point")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.sort_id);
/* 21 */     _os_.marshal(this.point);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.sort_id = _os_.unmarshal_int();
/* 28 */     this.point = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\confbean\SQianWenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */