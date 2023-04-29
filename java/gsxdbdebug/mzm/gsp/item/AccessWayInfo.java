/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AccessWayInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int accesswaytype;
/*    */   public ArrayList<Integer> idlist;
/*    */   
/*    */   public AccessWayInfo()
/*    */   {
/* 13 */     this.idlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public AccessWayInfo(int _accesswaytype_, ArrayList<Integer> _idlist_) {
/* 17 */     this.accesswaytype = _accesswaytype_;
/* 18 */     this.idlist = _idlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.accesswaytype);
/* 27 */     _os_.compact_uint32(this.idlist.size());
/* 28 */     for (Integer _v_ : this.idlist) {
/* 29 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.accesswaytype = _os_.unmarshal_int();
/* 36 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 38 */       int _v_ = _os_.unmarshal_int();
/* 39 */       this.idlist.add(Integer.valueOf(_v_));
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof AccessWayInfo)) {
/* 47 */       AccessWayInfo _o_ = (AccessWayInfo)_o1_;
/* 48 */       if (this.accesswaytype != _o_.accesswaytype) return false;
/* 49 */       if (!this.idlist.equals(_o_.idlist)) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.accesswaytype;
/* 58 */     _h_ += this.idlist.hashCode();
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.accesswaytype).append(",");
/* 66 */     _sb_.append(this.idlist).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\AccessWayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */