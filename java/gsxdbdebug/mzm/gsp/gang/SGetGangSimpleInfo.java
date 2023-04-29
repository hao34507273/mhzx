/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetGangSimpleInfo
/*    */   extends __SGetGangSimpleInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589851;
/*    */   public long gangid;
/*    */   public String gangname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589851;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetGangSimpleInfo()
/*    */   {
/* 34 */     this.gangname = "";
/*    */   }
/*    */   
/*    */   public SGetGangSimpleInfo(long _gangid_, String _gangname_) {
/* 38 */     this.gangid = _gangid_;
/* 39 */     this.gangname = _gangname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.gangid);
/* 48 */     _os_.marshal(this.gangname, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.gangid = _os_.unmarshal_long();
/* 54 */     this.gangname = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SGetGangSimpleInfo)) {
/* 64 */       SGetGangSimpleInfo _o_ = (SGetGangSimpleInfo)_o1_;
/* 65 */       if (this.gangid != _o_.gangid) return false;
/* 66 */       if (!this.gangname.equals(_o_.gangname)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.gangid;
/* 75 */     _h_ += this.gangname.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.gangid).append(",");
/* 83 */     _sb_.append("T").append(this.gangname.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SGetGangSimpleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */