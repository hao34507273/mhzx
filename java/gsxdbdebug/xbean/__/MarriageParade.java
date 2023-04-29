/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class MarriageParade extends XBean implements xbean.MarriageParade
/*      */ {
/*      */   private long roleid1;
/*      */   private long roleid2;
/*      */   private int level;
/*      */   private SetX<Integer> stoppointseqs;
/*      */   private SetX<Integer> givemoneypointseqs;
/*      */   private SetX<Integer> arriveseqs;
/*      */   private long timemil;
/*      */   private SetX<Integer> robseqs;
/*      */   private boolean canrob;
/*      */   private int bridefightstatus;
/*      */   private int groomfightstatus;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.roleid1 = 0L;
/*   39 */     this.roleid2 = 0L;
/*   40 */     this.level = 0;
/*   41 */     this.stoppointseqs.clear();
/*   42 */     this.givemoneypointseqs.clear();
/*   43 */     this.arriveseqs.clear();
/*   44 */     this.timemil = 0L;
/*   45 */     this.robseqs.clear();
/*   46 */     this.canrob = false;
/*   47 */     this.bridefightstatus = 0;
/*   48 */     this.groomfightstatus = 0;
/*      */   }
/*      */   
/*      */   MarriageParade(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.stoppointseqs = new SetX();
/*   55 */     this.givemoneypointseqs = new SetX();
/*   56 */     this.arriveseqs = new SetX();
/*   57 */     this.robseqs = new SetX();
/*   58 */     this.canrob = false;
/*      */   }
/*      */   
/*      */   public MarriageParade()
/*      */   {
/*   63 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MarriageParade(MarriageParade _o_)
/*      */   {
/*   68 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MarriageParade(xbean.MarriageParade _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   73 */     super(_xp_, _vn_);
/*   74 */     if ((_o1_ instanceof MarriageParade)) { assign((MarriageParade)_o1_);
/*   75 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   76 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   77 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MarriageParade _o_) {
/*   82 */     _o_._xdb_verify_unsafe_();
/*   83 */     this.roleid1 = _o_.roleid1;
/*   84 */     this.roleid2 = _o_.roleid2;
/*   85 */     this.level = _o_.level;
/*   86 */     this.stoppointseqs = new SetX();
/*   87 */     this.stoppointseqs.addAll(_o_.stoppointseqs);
/*   88 */     this.givemoneypointseqs = new SetX();
/*   89 */     this.givemoneypointseqs.addAll(_o_.givemoneypointseqs);
/*   90 */     this.arriveseqs = new SetX();
/*   91 */     this.arriveseqs.addAll(_o_.arriveseqs);
/*   92 */     this.timemil = _o_.timemil;
/*   93 */     this.robseqs = new SetX();
/*   94 */     this.robseqs.addAll(_o_.robseqs);
/*   95 */     this.canrob = _o_.canrob;
/*   96 */     this.bridefightstatus = _o_.bridefightstatus;
/*   97 */     this.groomfightstatus = _o_.groomfightstatus;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  102 */     this.roleid1 = _o_.roleid1;
/*  103 */     this.roleid2 = _o_.roleid2;
/*  104 */     this.level = _o_.level;
/*  105 */     this.stoppointseqs = new SetX();
/*  106 */     this.stoppointseqs.addAll(_o_.stoppointseqs);
/*  107 */     this.givemoneypointseqs = new SetX();
/*  108 */     this.givemoneypointseqs.addAll(_o_.givemoneypointseqs);
/*  109 */     this.arriveseqs = new SetX();
/*  110 */     this.arriveseqs.addAll(_o_.arriveseqs);
/*  111 */     this.timemil = _o_.timemil;
/*  112 */     this.robseqs = new SetX();
/*  113 */     this.robseqs.addAll(_o_.robseqs);
/*  114 */     this.canrob = _o_.canrob;
/*  115 */     this.bridefightstatus = _o_.bridefightstatus;
/*  116 */     this.groomfightstatus = _o_.groomfightstatus;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  122 */     _xdb_verify_unsafe_();
/*  123 */     _os_.marshal(this.roleid1);
/*  124 */     _os_.marshal(this.roleid2);
/*  125 */     _os_.marshal(this.level);
/*  126 */     _os_.compact_uint32(this.stoppointseqs.size());
/*  127 */     for (Integer _v_ : this.stoppointseqs)
/*      */     {
/*  129 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  131 */     _os_.compact_uint32(this.givemoneypointseqs.size());
/*  132 */     for (Integer _v_ : this.givemoneypointseqs)
/*      */     {
/*  134 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  136 */     _os_.compact_uint32(this.arriveseqs.size());
/*  137 */     for (Integer _v_ : this.arriveseqs)
/*      */     {
/*  139 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  141 */     _os_.marshal(this.timemil);
/*  142 */     _os_.compact_uint32(this.robseqs.size());
/*  143 */     for (Integer _v_ : this.robseqs)
/*      */     {
/*  145 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  147 */     _os_.marshal(this.canrob);
/*  148 */     _os_.marshal(this.bridefightstatus);
/*  149 */     _os_.marshal(this.groomfightstatus);
/*  150 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*  157 */     this.roleid1 = _os_.unmarshal_long();
/*  158 */     this.roleid2 = _os_.unmarshal_long();
/*  159 */     this.level = _os_.unmarshal_int();
/*  160 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  162 */       int _v_ = 0;
/*  163 */       _v_ = _os_.unmarshal_int();
/*  164 */       this.stoppointseqs.add(Integer.valueOf(_v_));
/*      */     }
/*  166 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  168 */       int _v_ = 0;
/*  169 */       _v_ = _os_.unmarshal_int();
/*  170 */       this.givemoneypointseqs.add(Integer.valueOf(_v_));
/*      */     }
/*  172 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  174 */       int _v_ = 0;
/*  175 */       _v_ = _os_.unmarshal_int();
/*  176 */       this.arriveseqs.add(Integer.valueOf(_v_));
/*      */     }
/*  178 */     this.timemil = _os_.unmarshal_long();
/*  179 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  181 */       int _v_ = 0;
/*  182 */       _v_ = _os_.unmarshal_int();
/*  183 */       this.robseqs.add(Integer.valueOf(_v_));
/*      */     }
/*  185 */     this.canrob = _os_.unmarshal_boolean();
/*  186 */     this.bridefightstatus = _os_.unmarshal_int();
/*  187 */     this.groomfightstatus = _os_.unmarshal_int();
/*  188 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*  195 */     int _size_ = 0;
/*  196 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid1);
/*  197 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleid2);
/*  198 */     _size_ += CodedOutputStream.computeInt32Size(3, this.level);
/*  199 */     for (Integer _v_ : this.stoppointseqs)
/*      */     {
/*  201 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  203 */     for (Integer _v_ : this.givemoneypointseqs)
/*      */     {
/*  205 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  207 */     for (Integer _v_ : this.arriveseqs)
/*      */     {
/*  209 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  211 */     _size_ += CodedOutputStream.computeInt64Size(7, this.timemil);
/*  212 */     for (Integer _v_ : this.robseqs)
/*      */     {
/*  214 */       _size_ += CodedOutputStream.computeInt32Size(8, _v_.intValue());
/*      */     }
/*  216 */     _size_ += CodedOutputStream.computeBoolSize(9, this.canrob);
/*  217 */     _size_ += CodedOutputStream.computeInt32Size(10, this.bridefightstatus);
/*  218 */     _size_ += CodedOutputStream.computeInt32Size(11, this.groomfightstatus);
/*  219 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  225 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  228 */       _output_.writeInt64(1, this.roleid1);
/*  229 */       _output_.writeInt64(2, this.roleid2);
/*  230 */       _output_.writeInt32(3, this.level);
/*  231 */       for (Integer _v_ : this.stoppointseqs)
/*      */       {
/*  233 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  235 */       for (Integer _v_ : this.givemoneypointseqs)
/*      */       {
/*  237 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  239 */       for (Integer _v_ : this.arriveseqs)
/*      */       {
/*  241 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  243 */       _output_.writeInt64(7, this.timemil);
/*  244 */       for (Integer _v_ : this.robseqs)
/*      */       {
/*  246 */         _output_.writeInt32(8, _v_.intValue());
/*      */       }
/*  248 */       _output_.writeBool(9, this.canrob);
/*  249 */       _output_.writeInt32(10, this.bridefightstatus);
/*  250 */       _output_.writeInt32(11, this.groomfightstatus);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  254 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  256 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  265 */       boolean done = false;
/*  266 */       while (!done)
/*      */       {
/*  268 */         int tag = _input_.readTag();
/*  269 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  273 */           done = true;
/*  274 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  278 */           this.roleid1 = _input_.readInt64();
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  283 */           this.roleid2 = _input_.readInt64();
/*  284 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  288 */           this.level = _input_.readInt32();
/*  289 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  293 */           int _v_ = 0;
/*  294 */           _v_ = _input_.readInt32();
/*  295 */           this.stoppointseqs.add(Integer.valueOf(_v_));
/*  296 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  300 */           int _v_ = 0;
/*  301 */           _v_ = _input_.readInt32();
/*  302 */           this.givemoneypointseqs.add(Integer.valueOf(_v_));
/*  303 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  307 */           int _v_ = 0;
/*  308 */           _v_ = _input_.readInt32();
/*  309 */           this.arriveseqs.add(Integer.valueOf(_v_));
/*  310 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  314 */           this.timemil = _input_.readInt64();
/*  315 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  319 */           int _v_ = 0;
/*  320 */           _v_ = _input_.readInt32();
/*  321 */           this.robseqs.add(Integer.valueOf(_v_));
/*  322 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  326 */           this.canrob = _input_.readBool();
/*  327 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  331 */           this.bridefightstatus = _input_.readInt32();
/*  332 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  336 */           this.groomfightstatus = _input_.readInt32();
/*  337 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  341 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  343 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  352 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  356 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  358 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarriageParade copy()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return new MarriageParade(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarriageParade toData()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarriageParade toBean()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return new MarriageParade(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarriageParade toDataIf()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarriageParade toBeanIf()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid1()
/*      */   {
/*  405 */     _xdb_verify_unsafe_();
/*  406 */     return this.roleid1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid2()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     return this.roleid2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getStoppointseqs()
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     return Logs.logSet(new LogKey(this, "stoppointseqs"), this.stoppointseqs);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getStoppointseqsAsData()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*      */     
/*  438 */     MarriageParade _o_ = this;
/*  439 */     Set<Integer> stoppointseqs = new SetX();
/*  440 */     stoppointseqs.addAll(_o_.stoppointseqs);
/*  441 */     return stoppointseqs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getGivemoneypointseqs()
/*      */   {
/*  448 */     _xdb_verify_unsafe_();
/*  449 */     return Logs.logSet(new LogKey(this, "givemoneypointseqs"), this.givemoneypointseqs);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getGivemoneypointseqsAsData()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*      */     
/*  457 */     MarriageParade _o_ = this;
/*  458 */     Set<Integer> givemoneypointseqs = new SetX();
/*  459 */     givemoneypointseqs.addAll(_o_.givemoneypointseqs);
/*  460 */     return givemoneypointseqs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getArriveseqs()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     return Logs.logSet(new LogKey(this, "arriveseqs"), this.arriveseqs);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getArriveseqsAsData()
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*      */     
/*  476 */     MarriageParade _o_ = this;
/*  477 */     Set<Integer> arriveseqs = new SetX();
/*  478 */     arriveseqs.addAll(_o_.arriveseqs);
/*  479 */     return arriveseqs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTimemil()
/*      */   {
/*  486 */     _xdb_verify_unsafe_();
/*  487 */     return this.timemil;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getRobseqs()
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     return Logs.logSet(new LogKey(this, "robseqs"), this.robseqs);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getRobseqsAsData()
/*      */   {
/*  501 */     _xdb_verify_unsafe_();
/*      */     
/*  503 */     MarriageParade _o_ = this;
/*  504 */     Set<Integer> robseqs = new SetX();
/*  505 */     robseqs.addAll(_o_.robseqs);
/*  506 */     return robseqs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getCanrob()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     return this.canrob;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBridefightstatus()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     return this.bridefightstatus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGroomfightstatus()
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     return this.groomfightstatus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid1(long _v_)
/*      */   {
/*  537 */     _xdb_verify_unsafe_();
/*  538 */     Logs.logIf(new LogKey(this, "roleid1")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  542 */         new LogLong(this, MarriageParade.this.roleid1)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  546 */             MarriageParade.this.roleid1 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  550 */     });
/*  551 */     this.roleid1 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid2(long _v_)
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     Logs.logIf(new LogKey(this, "roleid2")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  563 */         new LogLong(this, MarriageParade.this.roleid2)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  567 */             MarriageParade.this.roleid2 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  571 */     });
/*  572 */     this.roleid2 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  579 */     _xdb_verify_unsafe_();
/*  580 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  584 */         new LogInt(this, MarriageParade.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  588 */             MarriageParade.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  592 */     });
/*  593 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimemil(long _v_)
/*      */   {
/*  600 */     _xdb_verify_unsafe_();
/*  601 */     Logs.logIf(new LogKey(this, "timemil")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  605 */         new LogLong(this, MarriageParade.this.timemil)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  609 */             MarriageParade.this.timemil = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  613 */     });
/*  614 */     this.timemil = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCanrob(boolean _v_)
/*      */   {
/*  621 */     _xdb_verify_unsafe_();
/*  622 */     Logs.logIf(new LogKey(this, "canrob")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  626 */         new xdb.logs.LogObject(this, Boolean.valueOf(MarriageParade.this.canrob))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  630 */             MarriageParade.this.canrob = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  634 */     });
/*  635 */     this.canrob = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBridefightstatus(int _v_)
/*      */   {
/*  642 */     _xdb_verify_unsafe_();
/*  643 */     Logs.logIf(new LogKey(this, "bridefightstatus")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  647 */         new LogInt(this, MarriageParade.this.bridefightstatus)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  651 */             MarriageParade.this.bridefightstatus = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  655 */     });
/*  656 */     this.bridefightstatus = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroomfightstatus(int _v_)
/*      */   {
/*  663 */     _xdb_verify_unsafe_();
/*  664 */     Logs.logIf(new LogKey(this, "groomfightstatus")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  668 */         new LogInt(this, MarriageParade.this.groomfightstatus)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  672 */             MarriageParade.this.groomfightstatus = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  676 */     });
/*  677 */     this.groomfightstatus = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  683 */     _xdb_verify_unsafe_();
/*  684 */     MarriageParade _o_ = null;
/*  685 */     if ((_o1_ instanceof MarriageParade)) { _o_ = (MarriageParade)_o1_;
/*  686 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  687 */       return false;
/*  688 */     if (this.roleid1 != _o_.roleid1) return false;
/*  689 */     if (this.roleid2 != _o_.roleid2) return false;
/*  690 */     if (this.level != _o_.level) return false;
/*  691 */     if (!this.stoppointseqs.equals(_o_.stoppointseqs)) return false;
/*  692 */     if (!this.givemoneypointseqs.equals(_o_.givemoneypointseqs)) return false;
/*  693 */     if (!this.arriveseqs.equals(_o_.arriveseqs)) return false;
/*  694 */     if (this.timemil != _o_.timemil) return false;
/*  695 */     if (!this.robseqs.equals(_o_.robseqs)) return false;
/*  696 */     if (this.canrob != _o_.canrob) return false;
/*  697 */     if (this.bridefightstatus != _o_.bridefightstatus) return false;
/*  698 */     if (this.groomfightstatus != _o_.groomfightstatus) return false;
/*  699 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  705 */     _xdb_verify_unsafe_();
/*  706 */     int _h_ = 0;
/*  707 */     _h_ = (int)(_h_ + this.roleid1);
/*  708 */     _h_ = (int)(_h_ + this.roleid2);
/*  709 */     _h_ += this.level;
/*  710 */     _h_ += this.stoppointseqs.hashCode();
/*  711 */     _h_ += this.givemoneypointseqs.hashCode();
/*  712 */     _h_ += this.arriveseqs.hashCode();
/*  713 */     _h_ = (int)(_h_ + this.timemil);
/*  714 */     _h_ += this.robseqs.hashCode();
/*  715 */     _h_ += (this.canrob ? 1231 : 1237);
/*  716 */     _h_ += this.bridefightstatus;
/*  717 */     _h_ += this.groomfightstatus;
/*  718 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  724 */     _xdb_verify_unsafe_();
/*  725 */     StringBuilder _sb_ = new StringBuilder();
/*  726 */     _sb_.append("(");
/*  727 */     _sb_.append(this.roleid1);
/*  728 */     _sb_.append(",");
/*  729 */     _sb_.append(this.roleid2);
/*  730 */     _sb_.append(",");
/*  731 */     _sb_.append(this.level);
/*  732 */     _sb_.append(",");
/*  733 */     _sb_.append(this.stoppointseqs);
/*  734 */     _sb_.append(",");
/*  735 */     _sb_.append(this.givemoneypointseqs);
/*  736 */     _sb_.append(",");
/*  737 */     _sb_.append(this.arriveseqs);
/*  738 */     _sb_.append(",");
/*  739 */     _sb_.append(this.timemil);
/*  740 */     _sb_.append(",");
/*  741 */     _sb_.append(this.robseqs);
/*  742 */     _sb_.append(",");
/*  743 */     _sb_.append(this.canrob);
/*  744 */     _sb_.append(",");
/*  745 */     _sb_.append(this.bridefightstatus);
/*  746 */     _sb_.append(",");
/*  747 */     _sb_.append(this.groomfightstatus);
/*  748 */     _sb_.append(")");
/*  749 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  755 */     ListenableBean lb = new ListenableBean();
/*  756 */     lb.add(new ListenableChanged().setVarName("roleid1"));
/*  757 */     lb.add(new ListenableChanged().setVarName("roleid2"));
/*  758 */     lb.add(new ListenableChanged().setVarName("level"));
/*  759 */     lb.add(new ListenableSet().setVarName("stoppointseqs"));
/*  760 */     lb.add(new ListenableSet().setVarName("givemoneypointseqs"));
/*  761 */     lb.add(new ListenableSet().setVarName("arriveseqs"));
/*  762 */     lb.add(new ListenableChanged().setVarName("timemil"));
/*  763 */     lb.add(new ListenableSet().setVarName("robseqs"));
/*  764 */     lb.add(new ListenableChanged().setVarName("canrob"));
/*  765 */     lb.add(new ListenableChanged().setVarName("bridefightstatus"));
/*  766 */     lb.add(new ListenableChanged().setVarName("groomfightstatus"));
/*  767 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MarriageParade {
/*      */     private Const() {}
/*      */     
/*      */     MarriageParade nThis() {
/*  774 */       return MarriageParade.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  780 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarriageParade copy()
/*      */     {
/*  786 */       return MarriageParade.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarriageParade toData()
/*      */     {
/*  792 */       return MarriageParade.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MarriageParade toBean()
/*      */     {
/*  797 */       return MarriageParade.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarriageParade toDataIf()
/*      */     {
/*  803 */       return MarriageParade.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MarriageParade toBeanIf()
/*      */     {
/*  808 */       return MarriageParade.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid1()
/*      */     {
/*  815 */       MarriageParade.this._xdb_verify_unsafe_();
/*  816 */       return MarriageParade.this.roleid1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid2()
/*      */     {
/*  823 */       MarriageParade.this._xdb_verify_unsafe_();
/*  824 */       return MarriageParade.this.roleid2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  831 */       MarriageParade.this._xdb_verify_unsafe_();
/*  832 */       return MarriageParade.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getStoppointseqs()
/*      */     {
/*  839 */       MarriageParade.this._xdb_verify_unsafe_();
/*  840 */       return xdb.Consts.constSet(MarriageParade.this.stoppointseqs);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getStoppointseqsAsData()
/*      */     {
/*  846 */       MarriageParade.this._xdb_verify_unsafe_();
/*      */       
/*  848 */       MarriageParade _o_ = MarriageParade.this;
/*  849 */       Set<Integer> stoppointseqs = new SetX();
/*  850 */       stoppointseqs.addAll(_o_.stoppointseqs);
/*  851 */       return stoppointseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGivemoneypointseqs()
/*      */     {
/*  858 */       MarriageParade.this._xdb_verify_unsafe_();
/*  859 */       return xdb.Consts.constSet(MarriageParade.this.givemoneypointseqs);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getGivemoneypointseqsAsData()
/*      */     {
/*  865 */       MarriageParade.this._xdb_verify_unsafe_();
/*      */       
/*  867 */       MarriageParade _o_ = MarriageParade.this;
/*  868 */       Set<Integer> givemoneypointseqs = new SetX();
/*  869 */       givemoneypointseqs.addAll(_o_.givemoneypointseqs);
/*  870 */       return givemoneypointseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getArriveseqs()
/*      */     {
/*  877 */       MarriageParade.this._xdb_verify_unsafe_();
/*  878 */       return xdb.Consts.constSet(MarriageParade.this.arriveseqs);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getArriveseqsAsData()
/*      */     {
/*  884 */       MarriageParade.this._xdb_verify_unsafe_();
/*      */       
/*  886 */       MarriageParade _o_ = MarriageParade.this;
/*  887 */       Set<Integer> arriveseqs = new SetX();
/*  888 */       arriveseqs.addAll(_o_.arriveseqs);
/*  889 */       return arriveseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimemil()
/*      */     {
/*  896 */       MarriageParade.this._xdb_verify_unsafe_();
/*  897 */       return MarriageParade.this.timemil;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getRobseqs()
/*      */     {
/*  904 */       MarriageParade.this._xdb_verify_unsafe_();
/*  905 */       return xdb.Consts.constSet(MarriageParade.this.robseqs);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getRobseqsAsData()
/*      */     {
/*  911 */       MarriageParade.this._xdb_verify_unsafe_();
/*      */       
/*  913 */       MarriageParade _o_ = MarriageParade.this;
/*  914 */       Set<Integer> robseqs = new SetX();
/*  915 */       robseqs.addAll(_o_.robseqs);
/*  916 */       return robseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getCanrob()
/*      */     {
/*  923 */       MarriageParade.this._xdb_verify_unsafe_();
/*  924 */       return MarriageParade.this.canrob;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBridefightstatus()
/*      */     {
/*  931 */       MarriageParade.this._xdb_verify_unsafe_();
/*  932 */       return MarriageParade.this.bridefightstatus;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroomfightstatus()
/*      */     {
/*  939 */       MarriageParade.this._xdb_verify_unsafe_();
/*  940 */       return MarriageParade.this.groomfightstatus;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid1(long _v_)
/*      */     {
/*  947 */       MarriageParade.this._xdb_verify_unsafe_();
/*  948 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid2(long _v_)
/*      */     {
/*  955 */       MarriageParade.this._xdb_verify_unsafe_();
/*  956 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/*  963 */       MarriageParade.this._xdb_verify_unsafe_();
/*  964 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimemil(long _v_)
/*      */     {
/*  971 */       MarriageParade.this._xdb_verify_unsafe_();
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCanrob(boolean _v_)
/*      */     {
/*  979 */       MarriageParade.this._xdb_verify_unsafe_();
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBridefightstatus(int _v_)
/*      */     {
/*  987 */       MarriageParade.this._xdb_verify_unsafe_();
/*  988 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroomfightstatus(int _v_)
/*      */     {
/*  995 */       MarriageParade.this._xdb_verify_unsafe_();
/*  996 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1002 */       MarriageParade.this._xdb_verify_unsafe_();
/* 1003 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1009 */       MarriageParade.this._xdb_verify_unsafe_();
/* 1010 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1016 */       return MarriageParade.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1022 */       return MarriageParade.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1028 */       MarriageParade.this._xdb_verify_unsafe_();
/* 1029 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1035 */       return MarriageParade.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1041 */       return MarriageParade.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1047 */       MarriageParade.this._xdb_verify_unsafe_();
/* 1048 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1054 */       return MarriageParade.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1060 */       return MarriageParade.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1066 */       return MarriageParade.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1072 */       return MarriageParade.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1078 */       return MarriageParade.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1084 */       return MarriageParade.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1090 */       return MarriageParade.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MarriageParade
/*      */   {
/*      */     private long roleid1;
/*      */     
/*      */     private long roleid2;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private HashSet<Integer> stoppointseqs;
/*      */     
/*      */     private HashSet<Integer> givemoneypointseqs;
/*      */     
/*      */     private HashSet<Integer> arriveseqs;
/*      */     
/*      */     private long timemil;
/*      */     
/*      */     private HashSet<Integer> robseqs;
/*      */     
/*      */     private boolean canrob;
/*      */     
/*      */     private int bridefightstatus;
/*      */     
/*      */     private int groomfightstatus;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1122 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1127 */       this.stoppointseqs = new HashSet();
/* 1128 */       this.givemoneypointseqs = new HashSet();
/* 1129 */       this.arriveseqs = new HashSet();
/* 1130 */       this.robseqs = new HashSet();
/* 1131 */       this.canrob = false;
/*      */     }
/*      */     
/*      */     Data(xbean.MarriageParade _o1_)
/*      */     {
/* 1136 */       if ((_o1_ instanceof MarriageParade)) { assign((MarriageParade)_o1_);
/* 1137 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1138 */       } else if ((_o1_ instanceof MarriageParade.Const)) assign(((MarriageParade.Const)_o1_).nThis()); else {
/* 1139 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MarriageParade _o_) {
/* 1144 */       this.roleid1 = _o_.roleid1;
/* 1145 */       this.roleid2 = _o_.roleid2;
/* 1146 */       this.level = _o_.level;
/* 1147 */       this.stoppointseqs = new HashSet();
/* 1148 */       this.stoppointseqs.addAll(_o_.stoppointseqs);
/* 1149 */       this.givemoneypointseqs = new HashSet();
/* 1150 */       this.givemoneypointseqs.addAll(_o_.givemoneypointseqs);
/* 1151 */       this.arriveseqs = new HashSet();
/* 1152 */       this.arriveseqs.addAll(_o_.arriveseqs);
/* 1153 */       this.timemil = _o_.timemil;
/* 1154 */       this.robseqs = new HashSet();
/* 1155 */       this.robseqs.addAll(_o_.robseqs);
/* 1156 */       this.canrob = _o_.canrob;
/* 1157 */       this.bridefightstatus = _o_.bridefightstatus;
/* 1158 */       this.groomfightstatus = _o_.groomfightstatus;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1163 */       this.roleid1 = _o_.roleid1;
/* 1164 */       this.roleid2 = _o_.roleid2;
/* 1165 */       this.level = _o_.level;
/* 1166 */       this.stoppointseqs = new HashSet();
/* 1167 */       this.stoppointseqs.addAll(_o_.stoppointseqs);
/* 1168 */       this.givemoneypointseqs = new HashSet();
/* 1169 */       this.givemoneypointseqs.addAll(_o_.givemoneypointseqs);
/* 1170 */       this.arriveseqs = new HashSet();
/* 1171 */       this.arriveseqs.addAll(_o_.arriveseqs);
/* 1172 */       this.timemil = _o_.timemil;
/* 1173 */       this.robseqs = new HashSet();
/* 1174 */       this.robseqs.addAll(_o_.robseqs);
/* 1175 */       this.canrob = _o_.canrob;
/* 1176 */       this.bridefightstatus = _o_.bridefightstatus;
/* 1177 */       this.groomfightstatus = _o_.groomfightstatus;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1183 */       _os_.marshal(this.roleid1);
/* 1184 */       _os_.marshal(this.roleid2);
/* 1185 */       _os_.marshal(this.level);
/* 1186 */       _os_.compact_uint32(this.stoppointseqs.size());
/* 1187 */       for (Integer _v_ : this.stoppointseqs)
/*      */       {
/* 1189 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1191 */       _os_.compact_uint32(this.givemoneypointseqs.size());
/* 1192 */       for (Integer _v_ : this.givemoneypointseqs)
/*      */       {
/* 1194 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1196 */       _os_.compact_uint32(this.arriveseqs.size());
/* 1197 */       for (Integer _v_ : this.arriveseqs)
/*      */       {
/* 1199 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1201 */       _os_.marshal(this.timemil);
/* 1202 */       _os_.compact_uint32(this.robseqs.size());
/* 1203 */       for (Integer _v_ : this.robseqs)
/*      */       {
/* 1205 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1207 */       _os_.marshal(this.canrob);
/* 1208 */       _os_.marshal(this.bridefightstatus);
/* 1209 */       _os_.marshal(this.groomfightstatus);
/* 1210 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1216 */       this.roleid1 = _os_.unmarshal_long();
/* 1217 */       this.roleid2 = _os_.unmarshal_long();
/* 1218 */       this.level = _os_.unmarshal_int();
/* 1219 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1221 */         int _v_ = 0;
/* 1222 */         _v_ = _os_.unmarshal_int();
/* 1223 */         this.stoppointseqs.add(Integer.valueOf(_v_));
/*      */       }
/* 1225 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1227 */         int _v_ = 0;
/* 1228 */         _v_ = _os_.unmarshal_int();
/* 1229 */         this.givemoneypointseqs.add(Integer.valueOf(_v_));
/*      */       }
/* 1231 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1233 */         int _v_ = 0;
/* 1234 */         _v_ = _os_.unmarshal_int();
/* 1235 */         this.arriveseqs.add(Integer.valueOf(_v_));
/*      */       }
/* 1237 */       this.timemil = _os_.unmarshal_long();
/* 1238 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1240 */         int _v_ = 0;
/* 1241 */         _v_ = _os_.unmarshal_int();
/* 1242 */         this.robseqs.add(Integer.valueOf(_v_));
/*      */       }
/* 1244 */       this.canrob = _os_.unmarshal_boolean();
/* 1245 */       this.bridefightstatus = _os_.unmarshal_int();
/* 1246 */       this.groomfightstatus = _os_.unmarshal_int();
/* 1247 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1253 */       int _size_ = 0;
/* 1254 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid1);
/* 1255 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleid2);
/* 1256 */       _size_ += CodedOutputStream.computeInt32Size(3, this.level);
/* 1257 */       for (Integer _v_ : this.stoppointseqs)
/*      */       {
/* 1259 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/* 1261 */       for (Integer _v_ : this.givemoneypointseqs)
/*      */       {
/* 1263 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/* 1265 */       for (Integer _v_ : this.arriveseqs)
/*      */       {
/* 1267 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1269 */       _size_ += CodedOutputStream.computeInt64Size(7, this.timemil);
/* 1270 */       for (Integer _v_ : this.robseqs)
/*      */       {
/* 1272 */         _size_ += CodedOutputStream.computeInt32Size(8, _v_.intValue());
/*      */       }
/* 1274 */       _size_ += CodedOutputStream.computeBoolSize(9, this.canrob);
/* 1275 */       _size_ += CodedOutputStream.computeInt32Size(10, this.bridefightstatus);
/* 1276 */       _size_ += CodedOutputStream.computeInt32Size(11, this.groomfightstatus);
/* 1277 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1285 */         _output_.writeInt64(1, this.roleid1);
/* 1286 */         _output_.writeInt64(2, this.roleid2);
/* 1287 */         _output_.writeInt32(3, this.level);
/* 1288 */         for (Integer _v_ : this.stoppointseqs)
/*      */         {
/* 1290 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/* 1292 */         for (Integer _v_ : this.givemoneypointseqs)
/*      */         {
/* 1294 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/* 1296 */         for (Integer _v_ : this.arriveseqs)
/*      */         {
/* 1298 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/* 1300 */         _output_.writeInt64(7, this.timemil);
/* 1301 */         for (Integer _v_ : this.robseqs)
/*      */         {
/* 1303 */           _output_.writeInt32(8, _v_.intValue());
/*      */         }
/* 1305 */         _output_.writeBool(9, this.canrob);
/* 1306 */         _output_.writeInt32(10, this.bridefightstatus);
/* 1307 */         _output_.writeInt32(11, this.groomfightstatus);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1311 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1313 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1321 */         boolean done = false;
/* 1322 */         while (!done)
/*      */         {
/* 1324 */           int tag = _input_.readTag();
/* 1325 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1329 */             done = true;
/* 1330 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1334 */             this.roleid1 = _input_.readInt64();
/* 1335 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1339 */             this.roleid2 = _input_.readInt64();
/* 1340 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1344 */             this.level = _input_.readInt32();
/* 1345 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1349 */             int _v_ = 0;
/* 1350 */             _v_ = _input_.readInt32();
/* 1351 */             this.stoppointseqs.add(Integer.valueOf(_v_));
/* 1352 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1356 */             int _v_ = 0;
/* 1357 */             _v_ = _input_.readInt32();
/* 1358 */             this.givemoneypointseqs.add(Integer.valueOf(_v_));
/* 1359 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1363 */             int _v_ = 0;
/* 1364 */             _v_ = _input_.readInt32();
/* 1365 */             this.arriveseqs.add(Integer.valueOf(_v_));
/* 1366 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1370 */             this.timemil = _input_.readInt64();
/* 1371 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1375 */             int _v_ = 0;
/* 1376 */             _v_ = _input_.readInt32();
/* 1377 */             this.robseqs.add(Integer.valueOf(_v_));
/* 1378 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1382 */             this.canrob = _input_.readBool();
/* 1383 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1387 */             this.bridefightstatus = _input_.readInt32();
/* 1388 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1392 */             this.groomfightstatus = _input_.readInt32();
/* 1393 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1397 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1399 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1408 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1412 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1414 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarriageParade copy()
/*      */     {
/* 1420 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarriageParade toData()
/*      */     {
/* 1426 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MarriageParade toBean()
/*      */     {
/* 1431 */       return new MarriageParade(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarriageParade toDataIf()
/*      */     {
/* 1437 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MarriageParade toBeanIf()
/*      */     {
/* 1442 */       return new MarriageParade(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1448 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1452 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1456 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1460 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1464 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1468 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1472 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid1()
/*      */     {
/* 1479 */       return this.roleid1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid2()
/*      */     {
/* 1486 */       return this.roleid2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1493 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getStoppointseqs()
/*      */     {
/* 1500 */       return this.stoppointseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getStoppointseqsAsData()
/*      */     {
/* 1507 */       return this.stoppointseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGivemoneypointseqs()
/*      */     {
/* 1514 */       return this.givemoneypointseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGivemoneypointseqsAsData()
/*      */     {
/* 1521 */       return this.givemoneypointseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getArriveseqs()
/*      */     {
/* 1528 */       return this.arriveseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getArriveseqsAsData()
/*      */     {
/* 1535 */       return this.arriveseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimemil()
/*      */     {
/* 1542 */       return this.timemil;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getRobseqs()
/*      */     {
/* 1549 */       return this.robseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getRobseqsAsData()
/*      */     {
/* 1556 */       return this.robseqs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getCanrob()
/*      */     {
/* 1563 */       return this.canrob;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBridefightstatus()
/*      */     {
/* 1570 */       return this.bridefightstatus;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroomfightstatus()
/*      */     {
/* 1577 */       return this.groomfightstatus;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid1(long _v_)
/*      */     {
/* 1584 */       this.roleid1 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid2(long _v_)
/*      */     {
/* 1591 */       this.roleid2 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1598 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimemil(long _v_)
/*      */     {
/* 1605 */       this.timemil = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCanrob(boolean _v_)
/*      */     {
/* 1612 */       this.canrob = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBridefightstatus(int _v_)
/*      */     {
/* 1619 */       this.bridefightstatus = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroomfightstatus(int _v_)
/*      */     {
/* 1626 */       this.groomfightstatus = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1632 */       if (!(_o1_ instanceof Data)) return false;
/* 1633 */       Data _o_ = (Data)_o1_;
/* 1634 */       if (this.roleid1 != _o_.roleid1) return false;
/* 1635 */       if (this.roleid2 != _o_.roleid2) return false;
/* 1636 */       if (this.level != _o_.level) return false;
/* 1637 */       if (!this.stoppointseqs.equals(_o_.stoppointseqs)) return false;
/* 1638 */       if (!this.givemoneypointseqs.equals(_o_.givemoneypointseqs)) return false;
/* 1639 */       if (!this.arriveseqs.equals(_o_.arriveseqs)) return false;
/* 1640 */       if (this.timemil != _o_.timemil) return false;
/* 1641 */       if (!this.robseqs.equals(_o_.robseqs)) return false;
/* 1642 */       if (this.canrob != _o_.canrob) return false;
/* 1643 */       if (this.bridefightstatus != _o_.bridefightstatus) return false;
/* 1644 */       if (this.groomfightstatus != _o_.groomfightstatus) return false;
/* 1645 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1651 */       int _h_ = 0;
/* 1652 */       _h_ = (int)(_h_ + this.roleid1);
/* 1653 */       _h_ = (int)(_h_ + this.roleid2);
/* 1654 */       _h_ += this.level;
/* 1655 */       _h_ += this.stoppointseqs.hashCode();
/* 1656 */       _h_ += this.givemoneypointseqs.hashCode();
/* 1657 */       _h_ += this.arriveseqs.hashCode();
/* 1658 */       _h_ = (int)(_h_ + this.timemil);
/* 1659 */       _h_ += this.robseqs.hashCode();
/* 1660 */       _h_ += (this.canrob ? 1231 : 1237);
/* 1661 */       _h_ += this.bridefightstatus;
/* 1662 */       _h_ += this.groomfightstatus;
/* 1663 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1669 */       StringBuilder _sb_ = new StringBuilder();
/* 1670 */       _sb_.append("(");
/* 1671 */       _sb_.append(this.roleid1);
/* 1672 */       _sb_.append(",");
/* 1673 */       _sb_.append(this.roleid2);
/* 1674 */       _sb_.append(",");
/* 1675 */       _sb_.append(this.level);
/* 1676 */       _sb_.append(",");
/* 1677 */       _sb_.append(this.stoppointseqs);
/* 1678 */       _sb_.append(",");
/* 1679 */       _sb_.append(this.givemoneypointseqs);
/* 1680 */       _sb_.append(",");
/* 1681 */       _sb_.append(this.arriveseqs);
/* 1682 */       _sb_.append(",");
/* 1683 */       _sb_.append(this.timemil);
/* 1684 */       _sb_.append(",");
/* 1685 */       _sb_.append(this.robseqs);
/* 1686 */       _sb_.append(",");
/* 1687 */       _sb_.append(this.canrob);
/* 1688 */       _sb_.append(",");
/* 1689 */       _sb_.append(this.bridefightstatus);
/* 1690 */       _sb_.append(",");
/* 1691 */       _sb_.append(this.groomfightstatus);
/* 1692 */       _sb_.append(")");
/* 1693 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarriageParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */