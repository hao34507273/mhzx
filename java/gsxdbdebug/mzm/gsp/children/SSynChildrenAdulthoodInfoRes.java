/*    */ package mzm.gsp.children;
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
/*    */ public class SSynChildrenAdulthoodInfoRes
/*    */   extends __SSynChildrenAdulthoodInfoRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609406;
/*    */   public long childrenid;
/*    */   public AdulthoodInfo adulthoodinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609406;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynChildrenAdulthoodInfoRes()
/*    */   {
/* 34 */     this.adulthoodinfo = new AdulthoodInfo();
/*    */   }
/*    */   
/*    */   public SSynChildrenAdulthoodInfoRes(long _childrenid_, AdulthoodInfo _adulthoodinfo_) {
/* 38 */     this.childrenid = _childrenid_;
/* 39 */     this.adulthoodinfo = _adulthoodinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.adulthoodinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childrenid);
/* 49 */     _os_.marshal(this.adulthoodinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childrenid = _os_.unmarshal_long();
/* 55 */     this.adulthoodinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynChildrenAdulthoodInfoRes)) {
/* 65 */       SSynChildrenAdulthoodInfoRes _o_ = (SSynChildrenAdulthoodInfoRes)_o1_;
/* 66 */       if (this.childrenid != _o_.childrenid) return false;
/* 67 */       if (!this.adulthoodinfo.equals(_o_.adulthoodinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childrenid;
/* 76 */     _h_ += this.adulthoodinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childrenid).append(",");
/* 84 */     _sb_.append(this.adulthoodinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SSynChildrenAdulthoodInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */