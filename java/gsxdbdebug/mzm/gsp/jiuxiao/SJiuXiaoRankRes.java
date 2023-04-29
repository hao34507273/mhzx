/*    */ package mzm.gsp.jiuxiao;
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
/*    */ public class SJiuXiaoRankRes
/*    */   extends __SJiuXiaoRankRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12595473;
/*    */   public int ranktype;
/*    */   public ArrayList<JiuXiaoRankRoleData> rankdatas;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12595473;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SJiuXiaoRankRes()
/*    */   {
/* 34 */     this.rankdatas = new ArrayList();
/*    */   }
/*    */   
/*    */   public SJiuXiaoRankRes(int _ranktype_, ArrayList<JiuXiaoRankRoleData> _rankdatas_) {
/* 38 */     this.ranktype = _ranktype_;
/* 39 */     this.rankdatas = _rankdatas_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (JiuXiaoRankRoleData _v_ : this.rankdatas)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.ranktype);
/* 50 */     _os_.compact_uint32(this.rankdatas.size());
/* 51 */     for (JiuXiaoRankRoleData _v_ : this.rankdatas) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.ranktype = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       JiuXiaoRankRoleData _v_ = new JiuXiaoRankRoleData();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.rankdatas.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SJiuXiaoRankRes)) {
/* 73 */       SJiuXiaoRankRes _o_ = (SJiuXiaoRankRes)_o1_;
/* 74 */       if (this.ranktype != _o_.ranktype) return false;
/* 75 */       if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.ranktype;
/* 84 */     _h_ += this.rankdatas.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.ranktype).append(",");
/* 92 */     _sb_.append(this.rankdatas).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\SJiuXiaoRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */