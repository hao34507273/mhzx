/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SSynGroupJoinInfo
/*    */   extends __SSynGroupJoinInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605221;
/*    */   public ArrayList<GroupJoinInfo> group_join_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605221;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynGroupJoinInfo()
/*    */   {
/* 33 */     this.group_join_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynGroupJoinInfo(ArrayList<GroupJoinInfo> _group_join_infos_) {
/* 37 */     this.group_join_infos = _group_join_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (GroupJoinInfo _v_ : this.group_join_infos)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.group_join_infos.size());
/* 48 */     for (GroupJoinInfo _v_ : this.group_join_infos) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       GroupJoinInfo _v_ = new GroupJoinInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.group_join_infos.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynGroupJoinInfo)) {
/* 69 */       SSynGroupJoinInfo _o_ = (SSynGroupJoinInfo)_o1_;
/* 70 */       if (!this.group_join_infos.equals(_o_.group_join_infos)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.group_join_infos.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.group_join_infos).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SSynGroupJoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */