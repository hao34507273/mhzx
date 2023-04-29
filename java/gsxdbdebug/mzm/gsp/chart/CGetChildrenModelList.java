/*    */ package mzm.gsp.chart;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chart.main.PCGetChildrenModelList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetChildrenModelList
/*    */   extends __CGetChildrenModelList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587796;
/*    */   public ArrayList<Long> idlist;
/*    */   public int charttype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGetChildrenModelList(this.idlist, this.charttype, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12587796;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetChildrenModelList()
/*    */   {
/* 39 */     this.idlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public CGetChildrenModelList(ArrayList<Long> _idlist_, int _charttype_) {
/* 43 */     this.idlist = _idlist_;
/* 44 */     this.charttype = _charttype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.compact_uint32(this.idlist.size());
/* 53 */     for (Long _v_ : this.idlist) {
/* 54 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 56 */     _os_.marshal(this.charttype);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       long _v_ = _os_.unmarshal_long();
/* 64 */       this.idlist.add(Long.valueOf(_v_));
/*    */     }
/* 66 */     this.charttype = _os_.unmarshal_int();
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof CGetChildrenModelList)) {
/* 76 */       CGetChildrenModelList _o_ = (CGetChildrenModelList)_o1_;
/* 77 */       if (!this.idlist.equals(_o_.idlist)) return false;
/* 78 */       if (this.charttype != _o_.charttype) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.idlist.hashCode();
/* 87 */     _h_ += this.charttype;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.idlist).append(",");
/* 95 */     _sb_.append(this.charttype).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\CGetChildrenModelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */