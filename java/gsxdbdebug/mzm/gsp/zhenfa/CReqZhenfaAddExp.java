/*    */ package mzm.gsp.zhenfa;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.zhenfa.main.PZhenfaAddExp;
/*    */ 
/*    */ public class CReqZhenfaAddExp
/*    */   extends __CReqZhenfaAddExp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593157;
/*    */   public int zhenfaid;
/*    */   public ArrayList<NeedItemBean> needitemlist;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleid = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleid, new PZhenfaAddExp(roleid, this.zhenfaid, this.needitemlist));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12593157;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CReqZhenfaAddExp()
/*    */   {
/* 35 */     this.needitemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public CReqZhenfaAddExp(int _zhenfaid_, ArrayList<NeedItemBean> _needitemlist_) {
/* 39 */     this.zhenfaid = _zhenfaid_;
/* 40 */     this.needitemlist = _needitemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     for (NeedItemBean _v_ : this.needitemlist)
/* 45 */       if (!_v_._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.zhenfaid);
/* 51 */     _os_.compact_uint32(this.needitemlist.size());
/* 52 */     for (NeedItemBean _v_ : this.needitemlist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.zhenfaid = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 61 */       NeedItemBean _v_ = new NeedItemBean();
/* 62 */       _v_.unmarshal(_os_);
/* 63 */       this.needitemlist.add(_v_);
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof CReqZhenfaAddExp)) {
/* 74 */       CReqZhenfaAddExp _o_ = (CReqZhenfaAddExp)_o1_;
/* 75 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 76 */       if (!this.needitemlist.equals(_o_.needitemlist)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.zhenfaid;
/* 85 */     _h_ += this.needitemlist.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.zhenfaid).append(",");
/* 93 */     _sb_.append(this.needitemlist).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\CReqZhenfaAddExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */