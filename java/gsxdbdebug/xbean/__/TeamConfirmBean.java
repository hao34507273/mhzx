/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class TeamConfirmBean extends XBean implements xbean.TeamConfirmBean
/*     */ {
/*     */   private ArrayList<Long> allroles;
/*     */   private ArrayList<Long> acceptroles;
/*     */   private long sessionid;
/*     */   private TeamConfirmContext context;
/*     */   private long endtime;
/*     */   private int confirmtype;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  28 */     this.allroles.clear();
/*  29 */     this.acceptroles.clear();
/*  30 */     this.sessionid = 0L;
/*  31 */     this.context = null;
/*  32 */     this.endtime = 0L;
/*  33 */     this.confirmtype = 0;
/*     */   }
/*     */   
/*     */   TeamConfirmBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     this.allroles = new ArrayList();
/*  40 */     this.acceptroles = new ArrayList();
/*  41 */     this.context = null;
/*     */   }
/*     */   
/*     */   public TeamConfirmBean()
/*     */   {
/*  46 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TeamConfirmBean(TeamConfirmBean _o_)
/*     */   {
/*  51 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TeamConfirmBean(xbean.TeamConfirmBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  56 */     super(_xp_, _vn_);
/*  57 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  63 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  75 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  81 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  87 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TeamConfirmBean copy()
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*  94 */     return new TeamConfirmBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TeamConfirmBean toData()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TeamConfirmBean toBean()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     return new TeamConfirmBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TeamConfirmBean toDataIf()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TeamConfirmBean toBeanIf()
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/* 120 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/* 127 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAllroles()
/*     */   {
/* 134 */     _xdb_verify_unsafe_();
/* 135 */     return Logs.logList(new LogKey(this, "allroles"), this.allroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAllrolesAsData()
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     
/* 143 */     TeamConfirmBean _o_ = this;
/* 144 */     List<Long> allroles = new ArrayList();
/* 145 */     allroles.addAll(_o_.allroles);
/* 146 */     return allroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAcceptroles()
/*     */   {
/* 153 */     _xdb_verify_unsafe_();
/* 154 */     return Logs.logList(new LogKey(this, "acceptroles"), this.acceptroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAcceptrolesAsData()
/*     */   {
/* 160 */     _xdb_verify_unsafe_();
/*     */     
/* 162 */     TeamConfirmBean _o_ = this;
/* 163 */     List<Long> acceptroles = new ArrayList();
/* 164 */     acceptroles.addAll(_o_.acceptroles);
/* 165 */     return acceptroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public TeamConfirmContext getContext()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getEndtime()
/*     */   {
/* 188 */     _xdb_verify_unsafe_();
/* 189 */     return this.endtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getConfirmtype()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return this.confirmtype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 209 */         new xdb.logs.LogLong(this, TeamConfirmBean.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 213 */             TeamConfirmBean.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 217 */     });
/* 218 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContext(TeamConfirmContext _v_)
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     Logs.logIf(new LogKey(this, "context")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 230 */         new xdb.logs.LogObject(this, TeamConfirmBean.this.context)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 234 */             TeamConfirmBean.this.context = ((TeamConfirmContext)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 238 */     });
/* 239 */     this.context = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEndtime(long _v_)
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     Logs.logIf(new LogKey(this, "endtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 251 */         new xdb.logs.LogLong(this, TeamConfirmBean.this.endtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 255 */             TeamConfirmBean.this.endtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 259 */     });
/* 260 */     this.endtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setConfirmtype(int _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     Logs.logIf(new LogKey(this, "confirmtype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogInt(this, TeamConfirmBean.this.confirmtype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             TeamConfirmBean.this.confirmtype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.confirmtype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/* 288 */     TeamConfirmBean _o_ = null;
/* 289 */     if ((_o1_ instanceof TeamConfirmBean)) { _o_ = (TeamConfirmBean)_o1_;
/* 290 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 291 */       return false;
/* 292 */     if (!this.allroles.equals(_o_.allroles)) return false;
/* 293 */     if (!this.acceptroles.equals(_o_.acceptroles)) return false;
/* 294 */     if (this.sessionid != _o_.sessionid) return false;
/* 295 */     if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 296 */     if (this.endtime != _o_.endtime) return false;
/* 297 */     if (this.confirmtype != _o_.confirmtype) return false;
/* 298 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     int _h_ = 0;
/* 306 */     _h_ += this.allroles.hashCode();
/* 307 */     _h_ += this.acceptroles.hashCode();
/* 308 */     _h_ = (int)(_h_ + this.sessionid);
/* 309 */     _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 310 */     _h_ = (int)(_h_ + this.endtime);
/* 311 */     _h_ += this.confirmtype;
/* 312 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 318 */     _xdb_verify_unsafe_();
/* 319 */     StringBuilder _sb_ = new StringBuilder();
/* 320 */     _sb_.append("(");
/* 321 */     _sb_.append(this.allroles);
/* 322 */     _sb_.append(",");
/* 323 */     _sb_.append(this.acceptroles);
/* 324 */     _sb_.append(",");
/* 325 */     _sb_.append(this.sessionid);
/* 326 */     _sb_.append(",");
/* 327 */     _sb_.append(this.context);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.endtime);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.confirmtype);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("allroles"));
/* 341 */     lb.add(new ListenableChanged().setVarName("acceptroles"));
/* 342 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 343 */     lb.add(new ListenableChanged().setVarName("context"));
/* 344 */     lb.add(new ListenableChanged().setVarName("endtime"));
/* 345 */     lb.add(new ListenableChanged().setVarName("confirmtype"));
/* 346 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TeamConfirmBean {
/*     */     private Const() {}
/*     */     
/*     */     TeamConfirmBean nThis() {
/* 353 */       return TeamConfirmBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamConfirmBean copy()
/*     */     {
/* 365 */       return TeamConfirmBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamConfirmBean toData()
/*     */     {
/* 371 */       return TeamConfirmBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TeamConfirmBean toBean()
/*     */     {
/* 376 */       return TeamConfirmBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamConfirmBean toDataIf()
/*     */     {
/* 382 */       return TeamConfirmBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TeamConfirmBean toBeanIf()
/*     */     {
/* 387 */       return TeamConfirmBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroles()
/*     */     {
/* 394 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 395 */       return xdb.Consts.constList(TeamConfirmBean.this.allroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAllrolesAsData()
/*     */     {
/* 401 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/*     */       
/* 403 */       TeamConfirmBean _o_ = TeamConfirmBean.this;
/* 404 */       List<Long> allroles = new ArrayList();
/* 405 */       allroles.addAll(_o_.allroles);
/* 406 */       return allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAcceptroles()
/*     */     {
/* 413 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 414 */       return xdb.Consts.constList(TeamConfirmBean.this.acceptroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAcceptrolesAsData()
/*     */     {
/* 420 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/*     */       
/* 422 */       TeamConfirmBean _o_ = TeamConfirmBean.this;
/* 423 */       List<Long> acceptroles = new ArrayList();
/* 424 */       acceptroles.addAll(_o_.acceptroles);
/* 425 */       return acceptroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 432 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 433 */       return TeamConfirmBean.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public TeamConfirmContext getContext()
/*     */     {
/* 440 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 441 */       return TeamConfirmBean.this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 448 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 449 */       return TeamConfirmBean.this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getConfirmtype()
/*     */     {
/* 456 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 457 */       return TeamConfirmBean.this.confirmtype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 464 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(TeamConfirmContext _v_)
/*     */     {
/* 472 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 480 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 481 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setConfirmtype(int _v_)
/*     */     {
/* 488 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 495 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 496 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 502 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 503 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 509 */       return TeamConfirmBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 515 */       return TeamConfirmBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 521 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 522 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 528 */       return TeamConfirmBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 534 */       return TeamConfirmBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       TeamConfirmBean.this._xdb_verify_unsafe_();
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 547 */       return TeamConfirmBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 553 */       return TeamConfirmBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 559 */       return TeamConfirmBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 565 */       return TeamConfirmBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 571 */       return TeamConfirmBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 577 */       return TeamConfirmBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 583 */       return TeamConfirmBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TeamConfirmBean
/*     */   {
/*     */     private ArrayList<Long> allroles;
/*     */     
/*     */     private ArrayList<Long> acceptroles;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     private TeamConfirmContext context;
/*     */     
/*     */     private long endtime;
/*     */     
/*     */     private int confirmtype;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 605 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 610 */       this.allroles = new ArrayList();
/* 611 */       this.acceptroles = new ArrayList();
/* 612 */       this.context = null;
/*     */     }
/*     */     
/*     */     Data(xbean.TeamConfirmBean _o1_)
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 641 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 647 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamConfirmBean copy()
/*     */     {
/* 653 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamConfirmBean toData()
/*     */     {
/* 659 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TeamConfirmBean toBean()
/*     */     {
/* 664 */       return new TeamConfirmBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamConfirmBean toDataIf()
/*     */     {
/* 670 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TeamConfirmBean toBeanIf()
/*     */     {
/* 675 */       return new TeamConfirmBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 681 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 685 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 689 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 693 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 697 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 701 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 705 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroles()
/*     */     {
/* 712 */       return this.allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllrolesAsData()
/*     */     {
/* 719 */       return this.allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAcceptroles()
/*     */     {
/* 726 */       return this.acceptroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAcceptrolesAsData()
/*     */     {
/* 733 */       return this.acceptroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 740 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public TeamConfirmContext getContext()
/*     */     {
/* 747 */       return this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 754 */       return this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getConfirmtype()
/*     */     {
/* 761 */       return this.confirmtype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 768 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(TeamConfirmContext _v_)
/*     */     {
/* 775 */       this.context = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 782 */       this.endtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setConfirmtype(int _v_)
/*     */     {
/* 789 */       this.confirmtype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 795 */       if (!(_o1_ instanceof Data)) return false;
/* 796 */       Data _o_ = (Data)_o1_;
/* 797 */       if (!this.allroles.equals(_o_.allroles)) return false;
/* 798 */       if (!this.acceptroles.equals(_o_.acceptroles)) return false;
/* 799 */       if (this.sessionid != _o_.sessionid) return false;
/* 800 */       if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 801 */       if (this.endtime != _o_.endtime) return false;
/* 802 */       if (this.confirmtype != _o_.confirmtype) return false;
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 809 */       int _h_ = 0;
/* 810 */       _h_ += this.allroles.hashCode();
/* 811 */       _h_ += this.acceptroles.hashCode();
/* 812 */       _h_ = (int)(_h_ + this.sessionid);
/* 813 */       _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 814 */       _h_ = (int)(_h_ + this.endtime);
/* 815 */       _h_ += this.confirmtype;
/* 816 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 822 */       StringBuilder _sb_ = new StringBuilder();
/* 823 */       _sb_.append("(");
/* 824 */       _sb_.append(this.allroles);
/* 825 */       _sb_.append(",");
/* 826 */       _sb_.append(this.acceptroles);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.sessionid);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.context);
/* 831 */       _sb_.append(",");
/* 832 */       _sb_.append(this.endtime);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.confirmtype);
/* 835 */       _sb_.append(")");
/* 836 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TeamConfirmBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */