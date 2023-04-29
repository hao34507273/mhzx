/*    */ package mzm.gsp.avatar;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNotifyNewAvatar
/*    */   extends __SNotifyNewAvatar__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615174;
/*    */   public LinkedList<AvatarInfo> new_avatars;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615174;
/*    */   }
/*    */   
/*    */ 
/*    */   public SNotifyNewAvatar()
/*    */   {
/* 33 */     this.new_avatars = new LinkedList();
/*    */   }
/*    */   
/*    */   public SNotifyNewAvatar(LinkedList<AvatarInfo> _new_avatars_) {
/* 37 */     this.new_avatars = _new_avatars_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (AvatarInfo _v_ : this.new_avatars)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.new_avatars.size());
/* 48 */     for (AvatarInfo _v_ : this.new_avatars) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       AvatarInfo _v_ = new AvatarInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.new_avatars.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SNotifyNewAvatar)) {
/* 69 */       SNotifyNewAvatar _o_ = (SNotifyNewAvatar)_o1_;
/* 70 */       if (!this.new_avatars.equals(_o_.new_avatars)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.new_avatars.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.new_avatars).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\SNotifyNewAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */