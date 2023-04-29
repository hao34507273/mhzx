/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SDissolveGroupSuccessBrd
/*    */   extends __SDissolveGroupSuccessBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605188;
/*    */   public long groupid;
/*    */   public Octets group_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605188;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SDissolveGroupSuccessBrd()
/*    */   {
/* 34 */     this.group_name = new Octets();
/*    */   }
/*    */   
/*    */   public SDissolveGroupSuccessBrd(long _groupid_, Octets _group_name_) {
/* 38 */     this.groupid = _groupid_;
/* 39 */     this.group_name = _group_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.groupid);
/* 48 */     _os_.marshal(this.group_name);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.groupid = _os_.unmarshal_long();
/* 54 */     this.group_name = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SDissolveGroupSuccessBrd)) {
/* 64 */       SDissolveGroupSuccessBrd _o_ = (SDissolveGroupSuccessBrd)_o1_;
/* 65 */       if (this.groupid != _o_.groupid) return false;
/* 66 */       if (!this.group_name.equals(_o_.group_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.groupid;
/* 75 */     _h_ += this.group_name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.groupid).append(",");
/* 83 */     _sb_.append("B").append(this.group_name.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SDissolveGroupSuccessBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */