/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.breakegg.invite.InviteConfirmContext;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class InviteConfirmBean extends XBean implements xbean.InviteConfirmBean
/*     */ {
/*     */   private long sessionid;
/*     */   private int invitetype;
/*     */   private ArrayList<Long> allroles;
/*     */   private InviteConfirmContext context;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.sessionid = 0L;
/*  25 */     this.invitetype = 0;
/*  26 */     this.allroles.clear();
/*  27 */     this.context = null;
/*     */   }
/*     */   
/*     */   InviteConfirmBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.allroles = new ArrayList();
/*  34 */     this.context = null;
/*     */   }
/*     */   
/*     */   public InviteConfirmBean()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public InviteConfirmBean(InviteConfirmBean _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   InviteConfirmBean(xbean.InviteConfirmBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  56 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InviteConfirmBean copy()
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     return new InviteConfirmBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InviteConfirmBean toData()
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*  94 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.InviteConfirmBean toBean()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     return new InviteConfirmBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InviteConfirmBean toDataIf()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.InviteConfirmBean toBeanIf()
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/* 113 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/* 120 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/* 128 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getInvitetype()
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/* 136 */     return this.invitetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAllroles()
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/* 144 */     return xdb.Logs.logList(new LogKey(this, "allroles"), this.allroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAllrolesAsData()
/*     */   {
/* 150 */     _xdb_verify_unsafe_();
/*     */     
/* 152 */     InviteConfirmBean _o_ = this;
/* 153 */     List<Long> allroles = new ArrayList();
/* 154 */     allroles.addAll(_o_.allroles);
/* 155 */     return allroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public InviteConfirmContext getContext()
/*     */   {
/* 162 */     _xdb_verify_unsafe_();
/* 163 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 175 */         new xdb.logs.LogLong(this, InviteConfirmBean.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 179 */             InviteConfirmBean.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 183 */     });
/* 184 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInvitetype(int _v_)
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     xdb.Logs.logIf(new LogKey(this, "invitetype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 196 */         new xdb.logs.LogInt(this, InviteConfirmBean.this.invitetype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 200 */             InviteConfirmBean.this.invitetype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 204 */     });
/* 205 */     this.invitetype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContext(InviteConfirmContext _v_)
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     xdb.Logs.logIf(new LogKey(this, "context")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 217 */         new xdb.logs.LogObject(this, InviteConfirmBean.this.context)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 221 */             InviteConfirmBean.this.context = ((InviteConfirmContext)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 225 */     });
/* 226 */     this.context = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     InviteConfirmBean _o_ = null;
/* 234 */     if ((_o1_ instanceof InviteConfirmBean)) { _o_ = (InviteConfirmBean)_o1_;
/* 235 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 236 */       return false;
/* 237 */     if (this.sessionid != _o_.sessionid) return false;
/* 238 */     if (this.invitetype != _o_.invitetype) return false;
/* 239 */     if (!this.allroles.equals(_o_.allroles)) return false;
/* 240 */     if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 241 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     int _h_ = 0;
/* 249 */     _h_ = (int)(_h_ + this.sessionid);
/* 250 */     _h_ += this.invitetype;
/* 251 */     _h_ += this.allroles.hashCode();
/* 252 */     _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 253 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     StringBuilder _sb_ = new StringBuilder();
/* 261 */     _sb_.append("(");
/* 262 */     _sb_.append(this.sessionid);
/* 263 */     _sb_.append(",");
/* 264 */     _sb_.append(this.invitetype);
/* 265 */     _sb_.append(",");
/* 266 */     _sb_.append(this.allroles);
/* 267 */     _sb_.append(",");
/* 268 */     _sb_.append(this.context);
/* 269 */     _sb_.append(")");
/* 270 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 276 */     ListenableBean lb = new ListenableBean();
/* 277 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 278 */     lb.add(new ListenableChanged().setVarName("invitetype"));
/* 279 */     lb.add(new ListenableChanged().setVarName("allroles"));
/* 280 */     lb.add(new ListenableChanged().setVarName("context"));
/* 281 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.InviteConfirmBean {
/*     */     private Const() {}
/*     */     
/*     */     InviteConfirmBean nThis() {
/* 288 */       return InviteConfirmBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 294 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InviteConfirmBean copy()
/*     */     {
/* 300 */       return InviteConfirmBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InviteConfirmBean toData()
/*     */     {
/* 306 */       return InviteConfirmBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.InviteConfirmBean toBean()
/*     */     {
/* 311 */       return InviteConfirmBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InviteConfirmBean toDataIf()
/*     */     {
/* 317 */       return InviteConfirmBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.InviteConfirmBean toBeanIf()
/*     */     {
/* 322 */       return InviteConfirmBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 329 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 330 */       return InviteConfirmBean.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getInvitetype()
/*     */     {
/* 337 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 338 */       return InviteConfirmBean.this.invitetype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroles()
/*     */     {
/* 345 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 346 */       return xdb.Consts.constList(InviteConfirmBean.this.allroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAllrolesAsData()
/*     */     {
/* 352 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/*     */       
/* 354 */       InviteConfirmBean _o_ = InviteConfirmBean.this;
/* 355 */       List<Long> allroles = new ArrayList();
/* 356 */       allroles.addAll(_o_.allroles);
/* 357 */       return allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public InviteConfirmContext getContext()
/*     */     {
/* 364 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 365 */       return InviteConfirmBean.this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 372 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInvitetype(int _v_)
/*     */     {
/* 380 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(InviteConfirmContext _v_)
/*     */     {
/* 388 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 389 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 395 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 396 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 402 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 403 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 409 */       return InviteConfirmBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 415 */       return InviteConfirmBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 421 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 428 */       return InviteConfirmBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 434 */       return InviteConfirmBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 440 */       InviteConfirmBean.this._xdb_verify_unsafe_();
/* 441 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 447 */       return InviteConfirmBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 453 */       return InviteConfirmBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 459 */       return InviteConfirmBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 465 */       return InviteConfirmBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 471 */       return InviteConfirmBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 477 */       return InviteConfirmBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 483 */       return InviteConfirmBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.InviteConfirmBean
/*     */   {
/*     */     private long sessionid;
/*     */     
/*     */     private int invitetype;
/*     */     
/*     */     private ArrayList<Long> allroles;
/*     */     
/*     */     private InviteConfirmContext context;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 501 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 506 */       this.allroles = new ArrayList();
/* 507 */       this.context = null;
/*     */     }
/*     */     
/*     */     Data(xbean.InviteConfirmBean _o1_)
/*     */     {
/* 512 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 518 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 524 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 530 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 536 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InviteConfirmBean copy()
/*     */     {
/* 548 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InviteConfirmBean toData()
/*     */     {
/* 554 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.InviteConfirmBean toBean()
/*     */     {
/* 559 */       return new InviteConfirmBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InviteConfirmBean toDataIf()
/*     */     {
/* 565 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.InviteConfirmBean toBeanIf()
/*     */     {
/* 570 */       return new InviteConfirmBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 576 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 580 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 584 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 588 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 596 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 600 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 607 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getInvitetype()
/*     */     {
/* 614 */       return this.invitetype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroles()
/*     */     {
/* 621 */       return this.allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllrolesAsData()
/*     */     {
/* 628 */       return this.allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public InviteConfirmContext getContext()
/*     */     {
/* 635 */       return this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 642 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInvitetype(int _v_)
/*     */     {
/* 649 */       this.invitetype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(InviteConfirmContext _v_)
/*     */     {
/* 656 */       this.context = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 662 */       if (!(_o1_ instanceof Data)) return false;
/* 663 */       Data _o_ = (Data)_o1_;
/* 664 */       if (this.sessionid != _o_.sessionid) return false;
/* 665 */       if (this.invitetype != _o_.invitetype) return false;
/* 666 */       if (!this.allroles.equals(_o_.allroles)) return false;
/* 667 */       if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 668 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 674 */       int _h_ = 0;
/* 675 */       _h_ = (int)(_h_ + this.sessionid);
/* 676 */       _h_ += this.invitetype;
/* 677 */       _h_ += this.allroles.hashCode();
/* 678 */       _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 679 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 685 */       StringBuilder _sb_ = new StringBuilder();
/* 686 */       _sb_.append("(");
/* 687 */       _sb_.append(this.sessionid);
/* 688 */       _sb_.append(",");
/* 689 */       _sb_.append(this.invitetype);
/* 690 */       _sb_.append(",");
/* 691 */       _sb_.append(this.allroles);
/* 692 */       _sb_.append(",");
/* 693 */       _sb_.append(this.context);
/* 694 */       _sb_.append(")");
/* 695 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\InviteConfirmBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */