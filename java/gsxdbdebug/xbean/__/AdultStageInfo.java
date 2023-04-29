/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class AdultStageInfo extends XBean implements xbean.AdultStageInfo
/*      */ {
/*      */   private int animal_cfgid;
/*      */   private long last_mate_time;
/*      */   private int award_cfgid;
/*      */   private long birth_time;
/*      */   private int mate_times;
/*      */   private LinkedList<xbean.MateInfo> mate_infos;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.animal_cfgid = 0;
/*   29 */     this.last_mate_time = 0L;
/*   30 */     this.award_cfgid = 0;
/*   31 */     this.birth_time = 0L;
/*   32 */     this.mate_times = 0;
/*   33 */     this.mate_infos.clear();
/*      */   }
/*      */   
/*      */   AdultStageInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.mate_infos = new LinkedList();
/*      */   }
/*      */   
/*      */   public AdultStageInfo()
/*      */   {
/*   44 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AdultStageInfo(AdultStageInfo _o_)
/*      */   {
/*   49 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AdultStageInfo(xbean.AdultStageInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   54 */     super(_xp_, _vn_);
/*   55 */     if ((_o1_ instanceof AdultStageInfo)) { assign((AdultStageInfo)_o1_);
/*   56 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   57 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   58 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AdultStageInfo _o_) {
/*   63 */     _o_._xdb_verify_unsafe_();
/*   64 */     this.animal_cfgid = _o_.animal_cfgid;
/*   65 */     this.last_mate_time = _o_.last_mate_time;
/*   66 */     this.award_cfgid = _o_.award_cfgid;
/*   67 */     this.birth_time = _o_.birth_time;
/*   68 */     this.mate_times = _o_.mate_times;
/*   69 */     this.mate_infos = new LinkedList();
/*   70 */     for (xbean.MateInfo _v_ : _o_.mate_infos) {
/*   71 */       this.mate_infos.add(new MateInfo(_v_, this, "mate_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   76 */     this.animal_cfgid = _o_.animal_cfgid;
/*   77 */     this.last_mate_time = _o_.last_mate_time;
/*   78 */     this.award_cfgid = _o_.award_cfgid;
/*   79 */     this.birth_time = _o_.birth_time;
/*   80 */     this.mate_times = _o_.mate_times;
/*   81 */     this.mate_infos = new LinkedList();
/*   82 */     for (xbean.MateInfo _v_ : _o_.mate_infos) {
/*   83 */       this.mate_infos.add(new MateInfo(_v_, this, "mate_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.animal_cfgid);
/*   91 */     _os_.marshal(this.last_mate_time);
/*   92 */     _os_.marshal(this.award_cfgid);
/*   93 */     _os_.marshal(this.birth_time);
/*   94 */     _os_.marshal(this.mate_times);
/*   95 */     _os_.compact_uint32(this.mate_infos.size());
/*   96 */     for (xbean.MateInfo _v_ : this.mate_infos)
/*      */     {
/*   98 */       _v_.marshal(_os_);
/*      */     }
/*  100 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     this.animal_cfgid = _os_.unmarshal_int();
/*  108 */     this.last_mate_time = _os_.unmarshal_long();
/*  109 */     this.award_cfgid = _os_.unmarshal_int();
/*  110 */     this.birth_time = _os_.unmarshal_long();
/*  111 */     this.mate_times = _os_.unmarshal_int();
/*  112 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  114 */       xbean.MateInfo _v_ = new MateInfo(0, this, "mate_infos");
/*  115 */       _v_.unmarshal(_os_);
/*  116 */       this.mate_infos.add(_v_);
/*      */     }
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     int _size_ = 0;
/*  126 */     _size_ += CodedOutputStream.computeInt32Size(1, this.animal_cfgid);
/*  127 */     _size_ += CodedOutputStream.computeInt64Size(2, this.last_mate_time);
/*  128 */     _size_ += CodedOutputStream.computeInt32Size(3, this.award_cfgid);
/*  129 */     _size_ += CodedOutputStream.computeInt64Size(4, this.birth_time);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(5, this.mate_times);
/*  131 */     for (xbean.MateInfo _v_ : this.mate_infos)
/*      */     {
/*  133 */       _size_ += CodedOutputStream.computeMessageSize(6, _v_);
/*      */     }
/*  135 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  144 */       _output_.writeInt32(1, this.animal_cfgid);
/*  145 */       _output_.writeInt64(2, this.last_mate_time);
/*  146 */       _output_.writeInt32(3, this.award_cfgid);
/*  147 */       _output_.writeInt64(4, this.birth_time);
/*  148 */       _output_.writeInt32(5, this.mate_times);
/*  149 */       for (xbean.MateInfo _v_ : this.mate_infos)
/*      */       {
/*  151 */         _output_.writeMessage(6, _v_);
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  156 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  158 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       boolean done = false;
/*  168 */       while (!done)
/*      */       {
/*  170 */         int tag = _input_.readTag();
/*  171 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  175 */           done = true;
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  180 */           this.animal_cfgid = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  185 */           this.last_mate_time = _input_.readInt64();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  190 */           this.award_cfgid = _input_.readInt32();
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  195 */           this.birth_time = _input_.readInt64();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  200 */           this.mate_times = _input_.readInt32();
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  205 */           xbean.MateInfo _v_ = new MateInfo(0, this, "mate_infos");
/*  206 */           _input_.readMessage(_v_);
/*  207 */           this.mate_infos.add(_v_);
/*  208 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  212 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  214 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  223 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  227 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  229 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AdultStageInfo copy()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return new AdultStageInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AdultStageInfo toData()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AdultStageInfo toBean()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new AdultStageInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AdultStageInfo toDataIf()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AdultStageInfo toBeanIf()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAnimal_cfgid()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.animal_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_mate_time()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.last_mate_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAward_cfgid()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.award_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBirth_time()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.birth_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMate_times()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.mate_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.MateInfo> getMate_infos()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return Logs.logList(new LogKey(this, "mate_infos"), this.mate_infos);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.MateInfo> getMate_infosAsData()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*      */     
/*  325 */     AdultStageInfo _o_ = this;
/*  326 */     List<xbean.MateInfo> mate_infos = new LinkedList();
/*  327 */     for (xbean.MateInfo _v_ : _o_.mate_infos)
/*  328 */       mate_infos.add(new MateInfo.Data(_v_));
/*  329 */     return mate_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnimal_cfgid(int _v_)
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     Logs.logIf(new LogKey(this, "animal_cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  341 */         new LogInt(this, AdultStageInfo.this.animal_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             AdultStageInfo.this.animal_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.animal_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_mate_time(long _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     Logs.logIf(new LogKey(this, "last_mate_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  362 */         new xdb.logs.LogLong(this, AdultStageInfo.this.last_mate_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  366 */             AdultStageInfo.this.last_mate_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  370 */     });
/*  371 */     this.last_mate_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAward_cfgid(int _v_)
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     Logs.logIf(new LogKey(this, "award_cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  383 */         new LogInt(this, AdultStageInfo.this.award_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  387 */             AdultStageInfo.this.award_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  391 */     });
/*  392 */     this.award_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBirth_time(long _v_)
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     Logs.logIf(new LogKey(this, "birth_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  404 */         new xdb.logs.LogLong(this, AdultStageInfo.this.birth_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  408 */             AdultStageInfo.this.birth_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  412 */     });
/*  413 */     this.birth_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMate_times(int _v_)
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     Logs.logIf(new LogKey(this, "mate_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  425 */         new LogInt(this, AdultStageInfo.this.mate_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  429 */             AdultStageInfo.this.mate_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  433 */     });
/*  434 */     this.mate_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     AdultStageInfo _o_ = null;
/*  442 */     if ((_o1_ instanceof AdultStageInfo)) { _o_ = (AdultStageInfo)_o1_;
/*  443 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  444 */       return false;
/*  445 */     if (this.animal_cfgid != _o_.animal_cfgid) return false;
/*  446 */     if (this.last_mate_time != _o_.last_mate_time) return false;
/*  447 */     if (this.award_cfgid != _o_.award_cfgid) return false;
/*  448 */     if (this.birth_time != _o_.birth_time) return false;
/*  449 */     if (this.mate_times != _o_.mate_times) return false;
/*  450 */     if (!this.mate_infos.equals(_o_.mate_infos)) return false;
/*  451 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     int _h_ = 0;
/*  459 */     _h_ += this.animal_cfgid;
/*  460 */     _h_ = (int)(_h_ + this.last_mate_time);
/*  461 */     _h_ += this.award_cfgid;
/*  462 */     _h_ = (int)(_h_ + this.birth_time);
/*  463 */     _h_ += this.mate_times;
/*  464 */     _h_ += this.mate_infos.hashCode();
/*  465 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*  472 */     StringBuilder _sb_ = new StringBuilder();
/*  473 */     _sb_.append("(");
/*  474 */     _sb_.append(this.animal_cfgid);
/*  475 */     _sb_.append(",");
/*  476 */     _sb_.append(this.last_mate_time);
/*  477 */     _sb_.append(",");
/*  478 */     _sb_.append(this.award_cfgid);
/*  479 */     _sb_.append(",");
/*  480 */     _sb_.append(this.birth_time);
/*  481 */     _sb_.append(",");
/*  482 */     _sb_.append(this.mate_times);
/*  483 */     _sb_.append(",");
/*  484 */     _sb_.append(this.mate_infos);
/*  485 */     _sb_.append(")");
/*  486 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  492 */     ListenableBean lb = new ListenableBean();
/*  493 */     lb.add(new ListenableChanged().setVarName("animal_cfgid"));
/*  494 */     lb.add(new ListenableChanged().setVarName("last_mate_time"));
/*  495 */     lb.add(new ListenableChanged().setVarName("award_cfgid"));
/*  496 */     lb.add(new ListenableChanged().setVarName("birth_time"));
/*  497 */     lb.add(new ListenableChanged().setVarName("mate_times"));
/*  498 */     lb.add(new ListenableChanged().setVarName("mate_infos"));
/*  499 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AdultStageInfo {
/*      */     private Const() {}
/*      */     
/*      */     AdultStageInfo nThis() {
/*  506 */       return AdultStageInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  512 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdultStageInfo copy()
/*      */     {
/*  518 */       return AdultStageInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdultStageInfo toData()
/*      */     {
/*  524 */       return AdultStageInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AdultStageInfo toBean()
/*      */     {
/*  529 */       return AdultStageInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdultStageInfo toDataIf()
/*      */     {
/*  535 */       return AdultStageInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AdultStageInfo toBeanIf()
/*      */     {
/*  540 */       return AdultStageInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnimal_cfgid()
/*      */     {
/*  547 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  548 */       return AdultStageInfo.this.animal_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_mate_time()
/*      */     {
/*  555 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  556 */       return AdultStageInfo.this.last_mate_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAward_cfgid()
/*      */     {
/*  563 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  564 */       return AdultStageInfo.this.award_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBirth_time()
/*      */     {
/*  571 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  572 */       return AdultStageInfo.this.birth_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMate_times()
/*      */     {
/*  579 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  580 */       return AdultStageInfo.this.mate_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.MateInfo> getMate_infos()
/*      */     {
/*  587 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  588 */       return xdb.Consts.constList(AdultStageInfo.this.mate_infos);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.MateInfo> getMate_infosAsData()
/*      */     {
/*  594 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*      */       
/*  596 */       AdultStageInfo _o_ = AdultStageInfo.this;
/*  597 */       List<xbean.MateInfo> mate_infos = new LinkedList();
/*  598 */       for (xbean.MateInfo _v_ : _o_.mate_infos)
/*  599 */         mate_infos.add(new MateInfo.Data(_v_));
/*  600 */       return mate_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnimal_cfgid(int _v_)
/*      */     {
/*  607 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_mate_time(long _v_)
/*      */     {
/*  615 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  616 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAward_cfgid(int _v_)
/*      */     {
/*  623 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBirth_time(long _v_)
/*      */     {
/*  631 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMate_times(int _v_)
/*      */     {
/*  639 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  640 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  646 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  647 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  653 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  654 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  660 */       return AdultStageInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  666 */       return AdultStageInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  672 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  673 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  679 */       return AdultStageInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  685 */       return AdultStageInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  691 */       AdultStageInfo.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  698 */       return AdultStageInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  704 */       return AdultStageInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  710 */       return AdultStageInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  716 */       return AdultStageInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  722 */       return AdultStageInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  728 */       return AdultStageInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  734 */       return AdultStageInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AdultStageInfo
/*      */   {
/*      */     private int animal_cfgid;
/*      */     
/*      */     private long last_mate_time;
/*      */     
/*      */     private int award_cfgid;
/*      */     
/*      */     private long birth_time;
/*      */     
/*      */     private int mate_times;
/*      */     
/*      */     private LinkedList<xbean.MateInfo> mate_infos;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  756 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  761 */       this.mate_infos = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.AdultStageInfo _o1_)
/*      */     {
/*  766 */       if ((_o1_ instanceof AdultStageInfo)) { assign((AdultStageInfo)_o1_);
/*  767 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  768 */       } else if ((_o1_ instanceof AdultStageInfo.Const)) assign(((AdultStageInfo.Const)_o1_).nThis()); else {
/*  769 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AdultStageInfo _o_) {
/*  774 */       this.animal_cfgid = _o_.animal_cfgid;
/*  775 */       this.last_mate_time = _o_.last_mate_time;
/*  776 */       this.award_cfgid = _o_.award_cfgid;
/*  777 */       this.birth_time = _o_.birth_time;
/*  778 */       this.mate_times = _o_.mate_times;
/*  779 */       this.mate_infos = new LinkedList();
/*  780 */       for (xbean.MateInfo _v_ : _o_.mate_infos) {
/*  781 */         this.mate_infos.add(new MateInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  786 */       this.animal_cfgid = _o_.animal_cfgid;
/*  787 */       this.last_mate_time = _o_.last_mate_time;
/*  788 */       this.award_cfgid = _o_.award_cfgid;
/*  789 */       this.birth_time = _o_.birth_time;
/*  790 */       this.mate_times = _o_.mate_times;
/*  791 */       this.mate_infos = new LinkedList();
/*  792 */       for (xbean.MateInfo _v_ : _o_.mate_infos) {
/*  793 */         this.mate_infos.add(new MateInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  799 */       _os_.marshal(this.animal_cfgid);
/*  800 */       _os_.marshal(this.last_mate_time);
/*  801 */       _os_.marshal(this.award_cfgid);
/*  802 */       _os_.marshal(this.birth_time);
/*  803 */       _os_.marshal(this.mate_times);
/*  804 */       _os_.compact_uint32(this.mate_infos.size());
/*  805 */       for (xbean.MateInfo _v_ : this.mate_infos)
/*      */       {
/*  807 */         _v_.marshal(_os_);
/*      */       }
/*  809 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  815 */       this.animal_cfgid = _os_.unmarshal_int();
/*  816 */       this.last_mate_time = _os_.unmarshal_long();
/*  817 */       this.award_cfgid = _os_.unmarshal_int();
/*  818 */       this.birth_time = _os_.unmarshal_long();
/*  819 */       this.mate_times = _os_.unmarshal_int();
/*  820 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  822 */         xbean.MateInfo _v_ = xbean.Pod.newMateInfoData();
/*  823 */         _v_.unmarshal(_os_);
/*  824 */         this.mate_infos.add(_v_);
/*      */       }
/*  826 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  832 */       int _size_ = 0;
/*  833 */       _size_ += CodedOutputStream.computeInt32Size(1, this.animal_cfgid);
/*  834 */       _size_ += CodedOutputStream.computeInt64Size(2, this.last_mate_time);
/*  835 */       _size_ += CodedOutputStream.computeInt32Size(3, this.award_cfgid);
/*  836 */       _size_ += CodedOutputStream.computeInt64Size(4, this.birth_time);
/*  837 */       _size_ += CodedOutputStream.computeInt32Size(5, this.mate_times);
/*  838 */       for (xbean.MateInfo _v_ : this.mate_infos)
/*      */       {
/*  840 */         _size_ += CodedOutputStream.computeMessageSize(6, _v_);
/*      */       }
/*  842 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  850 */         _output_.writeInt32(1, this.animal_cfgid);
/*  851 */         _output_.writeInt64(2, this.last_mate_time);
/*  852 */         _output_.writeInt32(3, this.award_cfgid);
/*  853 */         _output_.writeInt64(4, this.birth_time);
/*  854 */         _output_.writeInt32(5, this.mate_times);
/*  855 */         for (xbean.MateInfo _v_ : this.mate_infos)
/*      */         {
/*  857 */           _output_.writeMessage(6, _v_);
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  862 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  864 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  872 */         boolean done = false;
/*  873 */         while (!done)
/*      */         {
/*  875 */           int tag = _input_.readTag();
/*  876 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  880 */             done = true;
/*  881 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  885 */             this.animal_cfgid = _input_.readInt32();
/*  886 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  890 */             this.last_mate_time = _input_.readInt64();
/*  891 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  895 */             this.award_cfgid = _input_.readInt32();
/*  896 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  900 */             this.birth_time = _input_.readInt64();
/*  901 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  905 */             this.mate_times = _input_.readInt32();
/*  906 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/*  910 */             xbean.MateInfo _v_ = xbean.Pod.newMateInfoData();
/*  911 */             _input_.readMessage(_v_);
/*  912 */             this.mate_infos.add(_v_);
/*  913 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  917 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  919 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  928 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  932 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  934 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdultStageInfo copy()
/*      */     {
/*  940 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdultStageInfo toData()
/*      */     {
/*  946 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AdultStageInfo toBean()
/*      */     {
/*  951 */       return new AdultStageInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdultStageInfo toDataIf()
/*      */     {
/*  957 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AdultStageInfo toBeanIf()
/*      */     {
/*  962 */       return new AdultStageInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  988 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  992 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnimal_cfgid()
/*      */     {
/*  999 */       return this.animal_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_mate_time()
/*      */     {
/* 1006 */       return this.last_mate_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAward_cfgid()
/*      */     {
/* 1013 */       return this.award_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBirth_time()
/*      */     {
/* 1020 */       return this.birth_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMate_times()
/*      */     {
/* 1027 */       return this.mate_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.MateInfo> getMate_infos()
/*      */     {
/* 1034 */       return this.mate_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.MateInfo> getMate_infosAsData()
/*      */     {
/* 1041 */       return this.mate_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnimal_cfgid(int _v_)
/*      */     {
/* 1048 */       this.animal_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_mate_time(long _v_)
/*      */     {
/* 1055 */       this.last_mate_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAward_cfgid(int _v_)
/*      */     {
/* 1062 */       this.award_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBirth_time(long _v_)
/*      */     {
/* 1069 */       this.birth_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMate_times(int _v_)
/*      */     {
/* 1076 */       this.mate_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1082 */       if (!(_o1_ instanceof Data)) return false;
/* 1083 */       Data _o_ = (Data)_o1_;
/* 1084 */       if (this.animal_cfgid != _o_.animal_cfgid) return false;
/* 1085 */       if (this.last_mate_time != _o_.last_mate_time) return false;
/* 1086 */       if (this.award_cfgid != _o_.award_cfgid) return false;
/* 1087 */       if (this.birth_time != _o_.birth_time) return false;
/* 1088 */       if (this.mate_times != _o_.mate_times) return false;
/* 1089 */       if (!this.mate_infos.equals(_o_.mate_infos)) return false;
/* 1090 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1096 */       int _h_ = 0;
/* 1097 */       _h_ += this.animal_cfgid;
/* 1098 */       _h_ = (int)(_h_ + this.last_mate_time);
/* 1099 */       _h_ += this.award_cfgid;
/* 1100 */       _h_ = (int)(_h_ + this.birth_time);
/* 1101 */       _h_ += this.mate_times;
/* 1102 */       _h_ += this.mate_infos.hashCode();
/* 1103 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1109 */       StringBuilder _sb_ = new StringBuilder();
/* 1110 */       _sb_.append("(");
/* 1111 */       _sb_.append(this.animal_cfgid);
/* 1112 */       _sb_.append(",");
/* 1113 */       _sb_.append(this.last_mate_time);
/* 1114 */       _sb_.append(",");
/* 1115 */       _sb_.append(this.award_cfgid);
/* 1116 */       _sb_.append(",");
/* 1117 */       _sb_.append(this.birth_time);
/* 1118 */       _sb_.append(",");
/* 1119 */       _sb_.append(this.mate_times);
/* 1120 */       _sb_.append(",");
/* 1121 */       _sb_.append(this.mate_infos);
/* 1122 */       _sb_.append(")");
/* 1123 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AdultStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */