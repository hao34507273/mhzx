/*    */ package mzm.gsp.map;
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
/*    */ public class SRoleExtraUpdateBrd
/*    */   extends __SRoleExtraUpdateBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590904;
/*    */   public long roleid;
/*    */   public int extra_type;
/*    */   public Octets extra_content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590904;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRoleExtraUpdateBrd()
/*    */   {
/* 35 */     this.extra_content = new Octets();
/*    */   }
/*    */   
/*    */   public SRoleExtraUpdateBrd(long _roleid_, int _extra_type_, Octets _extra_content_) {
/* 39 */     this.roleid = _roleid_;
/* 40 */     this.extra_type = _extra_type_;
/* 41 */     this.extra_content = _extra_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.extra_type);
/* 51 */     _os_.marshal(this.extra_content);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleid = _os_.unmarshal_long();
/* 57 */     this.extra_type = _os_.unmarshal_int();
/* 58 */     this.extra_content = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SRoleExtraUpdateBrd)) {
/* 68 */       SRoleExtraUpdateBrd _o_ = (SRoleExtraUpdateBrd)_o1_;
/* 69 */       if (this.roleid != _o_.roleid) return false;
/* 70 */       if (this.extra_type != _o_.extra_type) return false;
/* 71 */       if (!this.extra_content.equals(_o_.extra_content)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.roleid;
/* 80 */     _h_ += this.extra_type;
/* 81 */     _h_ += this.extra_content.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.roleid).append(",");
/* 89 */     _sb_.append(this.extra_type).append(",");
/* 90 */     _sb_.append("B").append(this.extra_content.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SRoleExtraUpdateBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */