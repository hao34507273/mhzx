/*    */ package mzm.gsp.team.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class OpertionCfg implements Marshal
/*    */ {
/*    */   public String optionName;
/*    */   public int optionLvFloor;
/*    */   public int optionLvTop;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.optionName = rootElement.attributeValue("optionName");
/* 16 */     this.optionLvFloor = Integer.valueOf(rootElement.attributeValue("optionLvFloor")).intValue();
/* 17 */     this.optionLvTop = Integer.valueOf(rootElement.attributeValue("optionLvTop")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.optionName, "UTF-8");
/* 23 */     _os_.marshal(this.optionLvFloor);
/* 24 */     _os_.marshal(this.optionLvTop);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.optionName = _os_.unmarshal_String("UTF-8");
/* 31 */     this.optionLvFloor = _os_.unmarshal_int();
/* 32 */     this.optionLvTop = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\confbean\OpertionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */