/*    */ package mzm.gsp.chart;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chart.main.PGetRoleModelListReq;
/*    */ 
/*    */ 
/*    */ public class CGetRoleModelList
/*    */   extends __CGetRoleModelList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587794;
/*    */   public ArrayList<Long> idlist;
/*    */   public int charttype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) return;
/* 21 */     Role.addRoleProcedure(roleId, new PGetRoleModelListReq(roleId, this.charttype, this.idlist));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12587794;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetRoleModelList()
/*    */   {
/* 36 */     this.idlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public CGetRoleModelList(ArrayList<Long> _idlist_, int _charttype_) {
/* 40 */     this.idlist = _idlist_;
/* 41 */     this.charttype = _charttype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.idlist.size());
/* 50 */     for (Long _v_ : this.idlist) {
/* 51 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 53 */     _os_.marshal(this.charttype);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 60 */       long _v_ = _os_.unmarshal_long();
/* 61 */       this.idlist.add(Long.valueOf(_v_));
/*    */     }
/* 63 */     this.charttype = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CGetRoleModelList)) {
/* 73 */       CGetRoleModelList _o_ = (CGetRoleModelList)_o1_;
/* 74 */       if (!this.idlist.equals(_o_.idlist)) return false;
/* 75 */       if (this.charttype != _o_.charttype) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.idlist.hashCode();
/* 84 */     _h_ += this.charttype;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.idlist).append(",");
/* 92 */     _sb_.append(this.charttype).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\CGetRoleModelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */