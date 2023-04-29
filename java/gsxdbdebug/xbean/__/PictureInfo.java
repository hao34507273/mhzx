/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.PictureQuestionInfo;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class PictureInfo extends XBean implements xbean.PictureInfo
/*     */ {
/*     */   private int state;
/*     */   private long sessionid;
/*     */   private ArrayList<Long> roleidlist;
/*     */   private int questionlevelcfgid;
/*     */   private int questionidx;
/*     */   private ArrayList<PictureQuestionInfo> questionlist;
/*     */   private int rightanswercount;
/*     */   private Object attachobject;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  32 */     this.state = 0;
/*  33 */     this.sessionid = 0L;
/*  34 */     this.roleidlist.clear();
/*  35 */     this.questionlevelcfgid = 0;
/*  36 */     this.questionidx = 0;
/*  37 */     this.questionlist.clear();
/*  38 */     this.rightanswercount = 0;
/*  39 */     this.attachobject = null;
/*     */   }
/*     */   
/*     */   PictureInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     this.roleidlist = new ArrayList();
/*  46 */     this.questionlist = new ArrayList();
/*  47 */     this.attachobject = null;
/*     */   }
/*     */   
/*     */   public PictureInfo()
/*     */   {
/*  52 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PictureInfo(PictureInfo _o_)
/*     */   {
/*  57 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PictureInfo(xbean.PictureInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  62 */     super(_xp_, _vn_);
/*  63 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  81 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  87 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PictureInfo copy()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     return new PictureInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PictureInfo toData()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PictureInfo toBean()
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/* 113 */     return new PictureInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PictureInfo toDataIf()
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/* 120 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PictureInfo toBeanIf()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/* 133 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getState()
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/* 141 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/* 149 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRoleidlist()
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/* 157 */     return Logs.logList(new LogKey(this, "roleidlist"), this.roleidlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRoleidlistAsData()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/*     */     
/* 165 */     PictureInfo _o_ = this;
/* 166 */     List<Long> roleidlist = new ArrayList();
/* 167 */     roleidlist.addAll(_o_.roleidlist);
/* 168 */     return roleidlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getQuestionlevelcfgid()
/*     */   {
/* 175 */     _xdb_verify_unsafe_();
/* 176 */     return this.questionlevelcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getQuestionidx()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this.questionidx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<PictureQuestionInfo> getQuestionlist()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return Logs.logList(new LogKey(this, "questionlist"), this.questionlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<PictureQuestionInfo> getQuestionlistAsData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/*     */     
/* 200 */     PictureInfo _o_ = this;
/* 201 */     List<PictureQuestionInfo> questionlist = new ArrayList();
/* 202 */     for (PictureQuestionInfo _v_ : _o_.questionlist)
/* 203 */       questionlist.add(new PictureQuestionInfo.Data(_v_));
/* 204 */     return questionlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRightanswercount()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this.rightanswercount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Object getAttachobject()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this.attachobject;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setState(int _v_)
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     Logs.logIf(new LogKey(this, "state")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 232 */         new LogInt(this, PictureInfo.this.state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 236 */             PictureInfo.this.state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 240 */     });
/* 241 */     this.state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 253 */         new xdb.logs.LogLong(this, PictureInfo.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 257 */             PictureInfo.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 261 */     });
/* 262 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuestionlevelcfgid(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     Logs.logIf(new LogKey(this, "questionlevelcfgid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 274 */         new LogInt(this, PictureInfo.this.questionlevelcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             PictureInfo.this.questionlevelcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.questionlevelcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuestionidx(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     Logs.logIf(new LogKey(this, "questionidx")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 295 */         new LogInt(this, PictureInfo.this.questionidx)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             PictureInfo.this.questionidx = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.questionidx = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRightanswercount(int _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     Logs.logIf(new LogKey(this, "rightanswercount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 316 */         new LogInt(this, PictureInfo.this.rightanswercount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             PictureInfo.this.rightanswercount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.rightanswercount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAttachobject(Object _v_)
/*     */   {
/* 332 */     _xdb_verify_unsafe_();
/* 333 */     Logs.logIf(new LogKey(this, "attachobject")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 337 */         new xdb.logs.LogObject(this, PictureInfo.this.attachobject)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 341 */             PictureInfo.this.attachobject = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 345 */     });
/* 346 */     this.attachobject = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 352 */     _xdb_verify_unsafe_();
/* 353 */     PictureInfo _o_ = null;
/* 354 */     if ((_o1_ instanceof PictureInfo)) { _o_ = (PictureInfo)_o1_;
/* 355 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 356 */       return false;
/* 357 */     if (this.state != _o_.state) return false;
/* 358 */     if (this.sessionid != _o_.sessionid) return false;
/* 359 */     if (!this.roleidlist.equals(_o_.roleidlist)) return false;
/* 360 */     if (this.questionlevelcfgid != _o_.questionlevelcfgid) return false;
/* 361 */     if (this.questionidx != _o_.questionidx) return false;
/* 362 */     if (!this.questionlist.equals(_o_.questionlist)) return false;
/* 363 */     if (this.rightanswercount != _o_.rightanswercount) return false;
/* 364 */     if (((null == this.attachobject) && (null != _o_.attachobject)) || ((null != this.attachobject) && (null == _o_.attachobject)) || ((null != this.attachobject) && (null != _o_.attachobject) && (!this.attachobject.equals(_o_.attachobject)))) return false;
/* 365 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 371 */     _xdb_verify_unsafe_();
/* 372 */     int _h_ = 0;
/* 373 */     _h_ += this.state;
/* 374 */     _h_ = (int)(_h_ + this.sessionid);
/* 375 */     _h_ += this.roleidlist.hashCode();
/* 376 */     _h_ += this.questionlevelcfgid;
/* 377 */     _h_ += this.questionidx;
/* 378 */     _h_ += this.questionlist.hashCode();
/* 379 */     _h_ += this.rightanswercount;
/* 380 */     _h_ += (this.attachobject == null ? 0 : this.attachobject.hashCode());
/* 381 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 387 */     _xdb_verify_unsafe_();
/* 388 */     StringBuilder _sb_ = new StringBuilder();
/* 389 */     _sb_.append("(");
/* 390 */     _sb_.append(this.state);
/* 391 */     _sb_.append(",");
/* 392 */     _sb_.append(this.sessionid);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.roleidlist);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.questionlevelcfgid);
/* 397 */     _sb_.append(",");
/* 398 */     _sb_.append(this.questionidx);
/* 399 */     _sb_.append(",");
/* 400 */     _sb_.append(this.questionlist);
/* 401 */     _sb_.append(",");
/* 402 */     _sb_.append(this.rightanswercount);
/* 403 */     _sb_.append(",");
/* 404 */     _sb_.append(this.attachobject);
/* 405 */     _sb_.append(")");
/* 406 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 412 */     ListenableBean lb = new ListenableBean();
/* 413 */     lb.add(new ListenableChanged().setVarName("state"));
/* 414 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 415 */     lb.add(new ListenableChanged().setVarName("roleidlist"));
/* 416 */     lb.add(new ListenableChanged().setVarName("questionlevelcfgid"));
/* 417 */     lb.add(new ListenableChanged().setVarName("questionidx"));
/* 418 */     lb.add(new ListenableChanged().setVarName("questionlist"));
/* 419 */     lb.add(new ListenableChanged().setVarName("rightanswercount"));
/* 420 */     lb.add(new ListenableChanged().setVarName("attachobject"));
/* 421 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PictureInfo {
/*     */     private Const() {}
/*     */     
/*     */     PictureInfo nThis() {
/* 428 */       return PictureInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PictureInfo copy()
/*     */     {
/* 440 */       return PictureInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PictureInfo toData()
/*     */     {
/* 446 */       return PictureInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PictureInfo toBean()
/*     */     {
/* 451 */       return PictureInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PictureInfo toDataIf()
/*     */     {
/* 457 */       return PictureInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PictureInfo toBeanIf()
/*     */     {
/* 462 */       return PictureInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getState()
/*     */     {
/* 469 */       PictureInfo.this._xdb_verify_unsafe_();
/* 470 */       return PictureInfo.this.state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 477 */       PictureInfo.this._xdb_verify_unsafe_();
/* 478 */       return PictureInfo.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidlist()
/*     */     {
/* 485 */       PictureInfo.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constList(PictureInfo.this.roleidlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRoleidlistAsData()
/*     */     {
/* 492 */       PictureInfo.this._xdb_verify_unsafe_();
/*     */       
/* 494 */       PictureInfo _o_ = PictureInfo.this;
/* 495 */       List<Long> roleidlist = new ArrayList();
/* 496 */       roleidlist.addAll(_o_.roleidlist);
/* 497 */       return roleidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getQuestionlevelcfgid()
/*     */     {
/* 504 */       PictureInfo.this._xdb_verify_unsafe_();
/* 505 */       return PictureInfo.this.questionlevelcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getQuestionidx()
/*     */     {
/* 512 */       PictureInfo.this._xdb_verify_unsafe_();
/* 513 */       return PictureInfo.this.questionidx;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<PictureQuestionInfo> getQuestionlist()
/*     */     {
/* 520 */       PictureInfo.this._xdb_verify_unsafe_();
/* 521 */       return xdb.Consts.constList(PictureInfo.this.questionlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<PictureQuestionInfo> getQuestionlistAsData()
/*     */     {
/* 527 */       PictureInfo.this._xdb_verify_unsafe_();
/*     */       
/* 529 */       PictureInfo _o_ = PictureInfo.this;
/* 530 */       List<PictureQuestionInfo> questionlist = new ArrayList();
/* 531 */       for (PictureQuestionInfo _v_ : _o_.questionlist)
/* 532 */         questionlist.add(new PictureQuestionInfo.Data(_v_));
/* 533 */       return questionlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightanswercount()
/*     */     {
/* 540 */       PictureInfo.this._xdb_verify_unsafe_();
/* 541 */       return PictureInfo.this.rightanswercount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Object getAttachobject()
/*     */     {
/* 548 */       PictureInfo.this._xdb_verify_unsafe_();
/* 549 */       return PictureInfo.this.attachobject;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setState(int _v_)
/*     */     {
/* 556 */       PictureInfo.this._xdb_verify_unsafe_();
/* 557 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 564 */       PictureInfo.this._xdb_verify_unsafe_();
/* 565 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuestionlevelcfgid(int _v_)
/*     */     {
/* 572 */       PictureInfo.this._xdb_verify_unsafe_();
/* 573 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuestionidx(int _v_)
/*     */     {
/* 580 */       PictureInfo.this._xdb_verify_unsafe_();
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightanswercount(int _v_)
/*     */     {
/* 588 */       PictureInfo.this._xdb_verify_unsafe_();
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAttachobject(Object _v_)
/*     */     {
/* 596 */       PictureInfo.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 603 */       PictureInfo.this._xdb_verify_unsafe_();
/* 604 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 610 */       PictureInfo.this._xdb_verify_unsafe_();
/* 611 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 617 */       return PictureInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 623 */       return PictureInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 629 */       PictureInfo.this._xdb_verify_unsafe_();
/* 630 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 636 */       return PictureInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 642 */       return PictureInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 648 */       PictureInfo.this._xdb_verify_unsafe_();
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 655 */       return PictureInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 661 */       return PictureInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 667 */       return PictureInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 673 */       return PictureInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 679 */       return PictureInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 685 */       return PictureInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 691 */       return PictureInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PictureInfo
/*     */   {
/*     */     private int state;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     private ArrayList<Long> roleidlist;
/*     */     
/*     */     private int questionlevelcfgid;
/*     */     
/*     */     private int questionidx;
/*     */     
/*     */     private ArrayList<PictureQuestionInfo> questionlist;
/*     */     
/*     */     private int rightanswercount;
/*     */     
/*     */     private Object attachobject;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 717 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 722 */       this.roleidlist = new ArrayList();
/* 723 */       this.questionlist = new ArrayList();
/* 724 */       this.attachobject = null;
/*     */     }
/*     */     
/*     */     Data(xbean.PictureInfo _o1_)
/*     */     {
/* 729 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 753 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 759 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PictureInfo copy()
/*     */     {
/* 765 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PictureInfo toData()
/*     */     {
/* 771 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PictureInfo toBean()
/*     */     {
/* 776 */       return new PictureInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PictureInfo toDataIf()
/*     */     {
/* 782 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PictureInfo toBeanIf()
/*     */     {
/* 787 */       return new PictureInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 797 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 801 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 805 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 809 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 813 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 817 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getState()
/*     */     {
/* 824 */       return this.state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 831 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidlist()
/*     */     {
/* 838 */       return this.roleidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidlistAsData()
/*     */     {
/* 845 */       return this.roleidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getQuestionlevelcfgid()
/*     */     {
/* 852 */       return this.questionlevelcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getQuestionidx()
/*     */     {
/* 859 */       return this.questionidx;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<PictureQuestionInfo> getQuestionlist()
/*     */     {
/* 866 */       return this.questionlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<PictureQuestionInfo> getQuestionlistAsData()
/*     */     {
/* 873 */       return this.questionlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightanswercount()
/*     */     {
/* 880 */       return this.rightanswercount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Object getAttachobject()
/*     */     {
/* 887 */       return this.attachobject;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setState(int _v_)
/*     */     {
/* 894 */       this.state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 901 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuestionlevelcfgid(int _v_)
/*     */     {
/* 908 */       this.questionlevelcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuestionidx(int _v_)
/*     */     {
/* 915 */       this.questionidx = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightanswercount(int _v_)
/*     */     {
/* 922 */       this.rightanswercount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAttachobject(Object _v_)
/*     */     {
/* 929 */       this.attachobject = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 935 */       if (!(_o1_ instanceof Data)) return false;
/* 936 */       Data _o_ = (Data)_o1_;
/* 937 */       if (this.state != _o_.state) return false;
/* 938 */       if (this.sessionid != _o_.sessionid) return false;
/* 939 */       if (!this.roleidlist.equals(_o_.roleidlist)) return false;
/* 940 */       if (this.questionlevelcfgid != _o_.questionlevelcfgid) return false;
/* 941 */       if (this.questionidx != _o_.questionidx) return false;
/* 942 */       if (!this.questionlist.equals(_o_.questionlist)) return false;
/* 943 */       if (this.rightanswercount != _o_.rightanswercount) return false;
/* 944 */       if (((null == this.attachobject) && (null != _o_.attachobject)) || ((null != this.attachobject) && (null == _o_.attachobject)) || ((null != this.attachobject) && (null != _o_.attachobject) && (!this.attachobject.equals(_o_.attachobject)))) return false;
/* 945 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 951 */       int _h_ = 0;
/* 952 */       _h_ += this.state;
/* 953 */       _h_ = (int)(_h_ + this.sessionid);
/* 954 */       _h_ += this.roleidlist.hashCode();
/* 955 */       _h_ += this.questionlevelcfgid;
/* 956 */       _h_ += this.questionidx;
/* 957 */       _h_ += this.questionlist.hashCode();
/* 958 */       _h_ += this.rightanswercount;
/* 959 */       _h_ += (this.attachobject == null ? 0 : this.attachobject.hashCode());
/* 960 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 966 */       StringBuilder _sb_ = new StringBuilder();
/* 967 */       _sb_.append("(");
/* 968 */       _sb_.append(this.state);
/* 969 */       _sb_.append(",");
/* 970 */       _sb_.append(this.sessionid);
/* 971 */       _sb_.append(",");
/* 972 */       _sb_.append(this.roleidlist);
/* 973 */       _sb_.append(",");
/* 974 */       _sb_.append(this.questionlevelcfgid);
/* 975 */       _sb_.append(",");
/* 976 */       _sb_.append(this.questionidx);
/* 977 */       _sb_.append(",");
/* 978 */       _sb_.append(this.questionlist);
/* 979 */       _sb_.append(",");
/* 980 */       _sb_.append(this.rightanswercount);
/* 981 */       _sb_.append(",");
/* 982 */       _sb_.append(this.attachobject);
/* 983 */       _sb_.append(")");
/* 984 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PictureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */