/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class ChineseValentineRound extends XBean implements xbean.ChineseValentineRound
/*      */ {
/*      */   private long sessionid;
/*      */   private int roundnumber;
/*      */   private long roundstarttime;
/*      */   private ArrayList<xbean.ChineseValentineCage> cageinfolist;
/*      */   private int state;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.sessionid = 0L;
/*   27 */     this.roundnumber = 0;
/*   28 */     this.roundstarttime = 0L;
/*   29 */     this.cageinfolist.clear();
/*   30 */     this.state = 0;
/*      */   }
/*      */   
/*      */   ChineseValentineRound(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.roundnumber = 0;
/*   37 */     this.cageinfolist = new ArrayList();
/*      */   }
/*      */   
/*      */   public ChineseValentineRound()
/*      */   {
/*   42 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChineseValentineRound(ChineseValentineRound _o_)
/*      */   {
/*   47 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChineseValentineRound(xbean.ChineseValentineRound _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   52 */     super(_xp_, _vn_);
/*   53 */     if ((_o1_ instanceof ChineseValentineRound)) { assign((ChineseValentineRound)_o1_);
/*   54 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   55 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   56 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChineseValentineRound _o_) {
/*   61 */     _o_._xdb_verify_unsafe_();
/*   62 */     this.sessionid = _o_.sessionid;
/*   63 */     this.roundnumber = _o_.roundnumber;
/*   64 */     this.roundstarttime = _o_.roundstarttime;
/*   65 */     this.cageinfolist = new ArrayList();
/*   66 */     for (xbean.ChineseValentineCage _v_ : _o_.cageinfolist)
/*   67 */       this.cageinfolist.add(new ChineseValentineCage(_v_, this, "cageinfolist"));
/*   68 */     this.state = _o_.state;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.sessionid = _o_.sessionid;
/*   74 */     this.roundnumber = _o_.roundnumber;
/*   75 */     this.roundstarttime = _o_.roundstarttime;
/*   76 */     this.cageinfolist = new ArrayList();
/*   77 */     for (xbean.ChineseValentineCage _v_ : _o_.cageinfolist)
/*   78 */       this.cageinfolist.add(new ChineseValentineCage(_v_, this, "cageinfolist"));
/*   79 */     this.state = _o_.state;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.marshal(this.sessionid);
/*   87 */     _os_.marshal(this.roundnumber);
/*   88 */     _os_.marshal(this.roundstarttime);
/*   89 */     _os_.compact_uint32(this.cageinfolist.size());
/*   90 */     for (xbean.ChineseValentineCage _v_ : this.cageinfolist)
/*      */     {
/*   92 */       _v_.marshal(_os_);
/*      */     }
/*   94 */     _os_.marshal(this.state);
/*   95 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     this.sessionid = _os_.unmarshal_long();
/*  103 */     this.roundnumber = _os_.unmarshal_int();
/*  104 */     this.roundstarttime = _os_.unmarshal_long();
/*  105 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  107 */       xbean.ChineseValentineCage _v_ = new ChineseValentineCage(0, this, "cageinfolist");
/*  108 */       _v_.unmarshal(_os_);
/*  109 */       this.cageinfolist.add(_v_);
/*      */     }
/*  111 */     this.state = _os_.unmarshal_int();
/*  112 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     int _size_ = 0;
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(1, this.sessionid);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(2, this.roundnumber);
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(3, this.roundstarttime);
/*  123 */     for (xbean.ChineseValentineCage _v_ : this.cageinfolist)
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(5, this.state);
/*  128 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  137 */       _output_.writeInt64(1, this.sessionid);
/*  138 */       _output_.writeInt32(2, this.roundnumber);
/*  139 */       _output_.writeInt64(3, this.roundstarttime);
/*  140 */       for (xbean.ChineseValentineCage _v_ : this.cageinfolist)
/*      */       {
/*  142 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  144 */       _output_.writeInt32(5, this.state);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  148 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  150 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  159 */       boolean done = false;
/*  160 */       while (!done)
/*      */       {
/*  162 */         int tag = _input_.readTag();
/*  163 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  167 */           done = true;
/*  168 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  172 */           this.sessionid = _input_.readInt64();
/*  173 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  177 */           this.roundnumber = _input_.readInt32();
/*  178 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  182 */           this.roundstarttime = _input_.readInt64();
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  187 */           xbean.ChineseValentineCage _v_ = new ChineseValentineCage(0, this, "cageinfolist");
/*  188 */           _input_.readMessage(_v_);
/*  189 */           this.cageinfolist.add(_v_);
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  194 */           this.state = _input_.readInt32();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  199 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  201 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  210 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  214 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  216 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChineseValentineRound copy()
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*  223 */     return new ChineseValentineRound(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChineseValentineRound toData()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChineseValentineRound toBean()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return new ChineseValentineRound(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChineseValentineRound toDataIf()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChineseValentineRound toBeanIf()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionid()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return this.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRoundnumber()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return this.roundnumber;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoundstarttime()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this.roundstarttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.ChineseValentineCage> getCageinfolist()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return xdb.Logs.logList(new LogKey(this, "cageinfolist"), this.cageinfolist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.ChineseValentineCage> getCageinfolistAsData()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*      */     
/*  296 */     ChineseValentineRound _o_ = this;
/*  297 */     List<xbean.ChineseValentineCage> cageinfolist = new ArrayList();
/*  298 */     for (xbean.ChineseValentineCage _v_ : _o_.cageinfolist)
/*  299 */       cageinfolist.add(new ChineseValentineCage.Data(_v_));
/*  300 */     return cageinfolist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionid(long _v_)
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  320 */         new xdb.logs.LogLong(this, ChineseValentineRound.this.sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  324 */             ChineseValentineRound.this.sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  328 */     });
/*  329 */     this.sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoundnumber(int _v_)
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "roundnumber")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  341 */         new xdb.logs.LogInt(this, ChineseValentineRound.this.roundnumber)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             ChineseValentineRound.this.roundnumber = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.roundnumber = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoundstarttime(long _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     xdb.Logs.logIf(new LogKey(this, "roundstarttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  362 */         new xdb.logs.LogLong(this, ChineseValentineRound.this.roundstarttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  366 */             ChineseValentineRound.this.roundstarttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  370 */     });
/*  371 */     this.roundstarttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     xdb.Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  383 */         new xdb.logs.LogInt(this, ChineseValentineRound.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  387 */             ChineseValentineRound.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  391 */     });
/*  392 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     ChineseValentineRound _o_ = null;
/*  400 */     if ((_o1_ instanceof ChineseValentineRound)) { _o_ = (ChineseValentineRound)_o1_;
/*  401 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  402 */       return false;
/*  403 */     if (this.sessionid != _o_.sessionid) return false;
/*  404 */     if (this.roundnumber != _o_.roundnumber) return false;
/*  405 */     if (this.roundstarttime != _o_.roundstarttime) return false;
/*  406 */     if (!this.cageinfolist.equals(_o_.cageinfolist)) return false;
/*  407 */     if (this.state != _o_.state) return false;
/*  408 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     int _h_ = 0;
/*  416 */     _h_ = (int)(_h_ + this.sessionid);
/*  417 */     _h_ += this.roundnumber;
/*  418 */     _h_ = (int)(_h_ + this.roundstarttime);
/*  419 */     _h_ += this.cageinfolist.hashCode();
/*  420 */     _h_ += this.state;
/*  421 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     StringBuilder _sb_ = new StringBuilder();
/*  429 */     _sb_.append("(");
/*  430 */     _sb_.append(this.sessionid);
/*  431 */     _sb_.append(",");
/*  432 */     _sb_.append(this.roundnumber);
/*  433 */     _sb_.append(",");
/*  434 */     _sb_.append(this.roundstarttime);
/*  435 */     _sb_.append(",");
/*  436 */     _sb_.append(this.cageinfolist);
/*  437 */     _sb_.append(",");
/*  438 */     _sb_.append(this.state);
/*  439 */     _sb_.append(")");
/*  440 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  446 */     ListenableBean lb = new ListenableBean();
/*  447 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/*  448 */     lb.add(new ListenableChanged().setVarName("roundnumber"));
/*  449 */     lb.add(new ListenableChanged().setVarName("roundstarttime"));
/*  450 */     lb.add(new ListenableChanged().setVarName("cageinfolist"));
/*  451 */     lb.add(new ListenableChanged().setVarName("state"));
/*  452 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChineseValentineRound {
/*      */     private Const() {}
/*      */     
/*      */     ChineseValentineRound nThis() {
/*  459 */       return ChineseValentineRound.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  465 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChineseValentineRound copy()
/*      */     {
/*  471 */       return ChineseValentineRound.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChineseValentineRound toData()
/*      */     {
/*  477 */       return ChineseValentineRound.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChineseValentineRound toBean()
/*      */     {
/*  482 */       return ChineseValentineRound.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChineseValentineRound toDataIf()
/*      */     {
/*  488 */       return ChineseValentineRound.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChineseValentineRound toBeanIf()
/*      */     {
/*  493 */       return ChineseValentineRound.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  500 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  501 */       return ChineseValentineRound.this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRoundnumber()
/*      */     {
/*  508 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  509 */       return ChineseValentineRound.this.roundnumber;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoundstarttime()
/*      */     {
/*  516 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  517 */       return ChineseValentineRound.this.roundstarttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ChineseValentineCage> getCageinfolist()
/*      */     {
/*  524 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  525 */       return xdb.Consts.constList(ChineseValentineRound.this.cageinfolist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.ChineseValentineCage> getCageinfolistAsData()
/*      */     {
/*  531 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*      */       
/*  533 */       ChineseValentineRound _o_ = ChineseValentineRound.this;
/*  534 */       List<xbean.ChineseValentineCage> cageinfolist = new ArrayList();
/*  535 */       for (xbean.ChineseValentineCage _v_ : _o_.cageinfolist)
/*  536 */         cageinfolist.add(new ChineseValentineCage.Data(_v_));
/*  537 */       return cageinfolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  544 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  545 */       return ChineseValentineRound.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/*  552 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  553 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoundnumber(int _v_)
/*      */     {
/*  560 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  561 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoundstarttime(long _v_)
/*      */     {
/*  568 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  569 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  576 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  583 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  584 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  590 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  591 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  597 */       return ChineseValentineRound.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  603 */       return ChineseValentineRound.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  609 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  610 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  616 */       return ChineseValentineRound.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  622 */       return ChineseValentineRound.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  628 */       ChineseValentineRound.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  635 */       return ChineseValentineRound.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  641 */       return ChineseValentineRound.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  647 */       return ChineseValentineRound.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  653 */       return ChineseValentineRound.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  659 */       return ChineseValentineRound.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  665 */       return ChineseValentineRound.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  671 */       return ChineseValentineRound.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChineseValentineRound
/*      */   {
/*      */     private long sessionid;
/*      */     
/*      */     private int roundnumber;
/*      */     
/*      */     private long roundstarttime;
/*      */     
/*      */     private ArrayList<xbean.ChineseValentineCage> cageinfolist;
/*      */     
/*      */     private int state;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  696 */       this.roundnumber = 0;
/*  697 */       this.cageinfolist = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.ChineseValentineRound _o1_)
/*      */     {
/*  702 */       if ((_o1_ instanceof ChineseValentineRound)) { assign((ChineseValentineRound)_o1_);
/*  703 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  704 */       } else if ((_o1_ instanceof ChineseValentineRound.Const)) assign(((ChineseValentineRound.Const)_o1_).nThis()); else {
/*  705 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChineseValentineRound _o_) {
/*  710 */       this.sessionid = _o_.sessionid;
/*  711 */       this.roundnumber = _o_.roundnumber;
/*  712 */       this.roundstarttime = _o_.roundstarttime;
/*  713 */       this.cageinfolist = new ArrayList();
/*  714 */       for (xbean.ChineseValentineCage _v_ : _o_.cageinfolist)
/*  715 */         this.cageinfolist.add(new ChineseValentineCage.Data(_v_));
/*  716 */       this.state = _o_.state;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  721 */       this.sessionid = _o_.sessionid;
/*  722 */       this.roundnumber = _o_.roundnumber;
/*  723 */       this.roundstarttime = _o_.roundstarttime;
/*  724 */       this.cageinfolist = new ArrayList();
/*  725 */       for (xbean.ChineseValentineCage _v_ : _o_.cageinfolist)
/*  726 */         this.cageinfolist.add(new ChineseValentineCage.Data(_v_));
/*  727 */       this.state = _o_.state;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  733 */       _os_.marshal(this.sessionid);
/*  734 */       _os_.marshal(this.roundnumber);
/*  735 */       _os_.marshal(this.roundstarttime);
/*  736 */       _os_.compact_uint32(this.cageinfolist.size());
/*  737 */       for (xbean.ChineseValentineCage _v_ : this.cageinfolist)
/*      */       {
/*  739 */         _v_.marshal(_os_);
/*      */       }
/*  741 */       _os_.marshal(this.state);
/*  742 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  748 */       this.sessionid = _os_.unmarshal_long();
/*  749 */       this.roundnumber = _os_.unmarshal_int();
/*  750 */       this.roundstarttime = _os_.unmarshal_long();
/*  751 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  753 */         xbean.ChineseValentineCage _v_ = xbean.Pod.newChineseValentineCageData();
/*  754 */         _v_.unmarshal(_os_);
/*  755 */         this.cageinfolist.add(_v_);
/*      */       }
/*  757 */       this.state = _os_.unmarshal_int();
/*  758 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  764 */       int _size_ = 0;
/*  765 */       _size_ += CodedOutputStream.computeInt64Size(1, this.sessionid);
/*  766 */       _size_ += CodedOutputStream.computeInt32Size(2, this.roundnumber);
/*  767 */       _size_ += CodedOutputStream.computeInt64Size(3, this.roundstarttime);
/*  768 */       for (xbean.ChineseValentineCage _v_ : this.cageinfolist)
/*      */       {
/*  770 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/*  772 */       _size_ += CodedOutputStream.computeInt32Size(5, this.state);
/*  773 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  781 */         _output_.writeInt64(1, this.sessionid);
/*  782 */         _output_.writeInt32(2, this.roundnumber);
/*  783 */         _output_.writeInt64(3, this.roundstarttime);
/*  784 */         for (xbean.ChineseValentineCage _v_ : this.cageinfolist)
/*      */         {
/*  786 */           _output_.writeMessage(4, _v_);
/*      */         }
/*  788 */         _output_.writeInt32(5, this.state);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  792 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  794 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  802 */         boolean done = false;
/*  803 */         while (!done)
/*      */         {
/*  805 */           int tag = _input_.readTag();
/*  806 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  810 */             done = true;
/*  811 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  815 */             this.sessionid = _input_.readInt64();
/*  816 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  820 */             this.roundnumber = _input_.readInt32();
/*  821 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  825 */             this.roundstarttime = _input_.readInt64();
/*  826 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  830 */             xbean.ChineseValentineCage _v_ = xbean.Pod.newChineseValentineCageData();
/*  831 */             _input_.readMessage(_v_);
/*  832 */             this.cageinfolist.add(_v_);
/*  833 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  837 */             this.state = _input_.readInt32();
/*  838 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  842 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  844 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  853 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  857 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  859 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChineseValentineRound copy()
/*      */     {
/*  865 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChineseValentineRound toData()
/*      */     {
/*  871 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChineseValentineRound toBean()
/*      */     {
/*  876 */       return new ChineseValentineRound(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChineseValentineRound toDataIf()
/*      */     {
/*  882 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChineseValentineRound toBeanIf()
/*      */     {
/*  887 */       return new ChineseValentineRound(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  897 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  901 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  905 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  913 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  917 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  924 */       return this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRoundnumber()
/*      */     {
/*  931 */       return this.roundnumber;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoundstarttime()
/*      */     {
/*  938 */       return this.roundstarttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ChineseValentineCage> getCageinfolist()
/*      */     {
/*  945 */       return this.cageinfolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ChineseValentineCage> getCageinfolistAsData()
/*      */     {
/*  952 */       return this.cageinfolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  959 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/*  966 */       this.sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoundnumber(int _v_)
/*      */     {
/*  973 */       this.roundnumber = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoundstarttime(long _v_)
/*      */     {
/*  980 */       this.roundstarttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  987 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  993 */       if (!(_o1_ instanceof Data)) return false;
/*  994 */       Data _o_ = (Data)_o1_;
/*  995 */       if (this.sessionid != _o_.sessionid) return false;
/*  996 */       if (this.roundnumber != _o_.roundnumber) return false;
/*  997 */       if (this.roundstarttime != _o_.roundstarttime) return false;
/*  998 */       if (!this.cageinfolist.equals(_o_.cageinfolist)) return false;
/*  999 */       if (this.state != _o_.state) return false;
/* 1000 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1006 */       int _h_ = 0;
/* 1007 */       _h_ = (int)(_h_ + this.sessionid);
/* 1008 */       _h_ += this.roundnumber;
/* 1009 */       _h_ = (int)(_h_ + this.roundstarttime);
/* 1010 */       _h_ += this.cageinfolist.hashCode();
/* 1011 */       _h_ += this.state;
/* 1012 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1018 */       StringBuilder _sb_ = new StringBuilder();
/* 1019 */       _sb_.append("(");
/* 1020 */       _sb_.append(this.sessionid);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.roundnumber);
/* 1023 */       _sb_.append(",");
/* 1024 */       _sb_.append(this.roundstarttime);
/* 1025 */       _sb_.append(",");
/* 1026 */       _sb_.append(this.cageinfolist);
/* 1027 */       _sb_.append(",");
/* 1028 */       _sb_.append(this.state);
/* 1029 */       _sb_.append(")");
/* 1030 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChineseValentineRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */