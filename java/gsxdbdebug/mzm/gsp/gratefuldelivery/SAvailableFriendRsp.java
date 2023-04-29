/*    */ package mzm.gsp.gratefuldelivery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SAvailableFriendRsp
/*    */   extends __SAvailableFriendRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615688;
/*    */   public LinkedList<Long> roles;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12615688;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAvailableFriendRsp()
/*    */   {
/* 32 */     this.roles = new LinkedList();
/*    */   }
/*    */   
/*    */   public SAvailableFriendRsp(LinkedList<Long> _roles_, int _activity_id_) {
/* 36 */     this.roles = _roles_;
/* 37 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.roles.size());
/* 46 */     for (Long _v_ : this.roles) {
/* 47 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 49 */     _os_.marshal(this.activity_id);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 56 */       long _v_ = _os_.unmarshal_long();
/* 57 */       this.roles.add(Long.valueOf(_v_));
/*    */     }
/* 59 */     this.activity_id = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SAvailableFriendRsp)) {
/* 69 */       SAvailableFriendRsp _o_ = (SAvailableFriendRsp)_o1_;
/* 70 */       if (!this.roles.equals(_o_.roles)) return false;
/* 71 */       if (this.activity_id != _o_.activity_id) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.roles.hashCode();
/* 80 */     _h_ += this.activity_id;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.roles).append(",");
/* 88 */     _sb_.append(this.activity_id).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SAvailableFriendRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */