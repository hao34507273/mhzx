/*    */ package mzm.gsp.chart;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chart.main.PGetPetModelListReq;
/*    */ 
/*    */ 
/*    */ public class CGetPetModelList
/*    */   extends __CGetPetModelList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587791;
/*    */   public ArrayList<PetOwner> idlist;
/*    */   public int charttype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) return;
/* 21 */     Role.addRoleProcedure(roleId, new PGetPetModelListReq(roleId, this.charttype, this.idlist));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12587791;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetPetModelList()
/*    */   {
/* 36 */     this.idlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public CGetPetModelList(ArrayList<PetOwner> _idlist_, int _charttype_) {
/* 40 */     this.idlist = _idlist_;
/* 41 */     this.charttype = _charttype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     for (PetOwner _v_ : this.idlist)
/* 46 */       if (!_v_._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.idlist.size());
/* 52 */     for (PetOwner _v_ : this.idlist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     _os_.marshal(this.charttype);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 61 */       PetOwner _v_ = new PetOwner();
/* 62 */       _v_.unmarshal(_os_);
/* 63 */       this.idlist.add(_v_);
/*    */     }
/* 65 */     this.charttype = _os_.unmarshal_int();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CGetPetModelList)) {
/* 75 */       CGetPetModelList _o_ = (CGetPetModelList)_o1_;
/* 76 */       if (!this.idlist.equals(_o_.idlist)) return false;
/* 77 */       if (this.charttype != _o_.charttype) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.idlist.hashCode();
/* 86 */     _h_ += this.charttype;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.idlist).append(",");
/* 94 */     _sb_.append(this.charttype).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\CGetPetModelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */