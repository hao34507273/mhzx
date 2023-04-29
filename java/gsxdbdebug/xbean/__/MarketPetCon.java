/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class MarketPetCon extends XBean implements xbean.MarketPetCon
/*      */ {
/*      */   private SetX<Integer> qualitys;
/*      */   private SetX<Integer> pettypes;
/*      */   private int skillnum;
/*      */   private SetX<Integer> skillids;
/*      */   private long custtime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.qualitys.clear();
/*   27 */     this.pettypes.clear();
/*   28 */     this.skillnum = 0;
/*   29 */     this.skillids.clear();
/*   30 */     this.custtime = 0L;
/*      */   }
/*      */   
/*      */   MarketPetCon(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.qualitys = new SetX();
/*   37 */     this.pettypes = new SetX();
/*   38 */     this.skillids = new SetX();
/*      */   }
/*      */   
/*      */   public MarketPetCon()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MarketPetCon(MarketPetCon _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MarketPetCon(xbean.MarketPetCon _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof MarketPetCon)) { assign((MarketPetCon)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MarketPetCon _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.qualitys = new SetX();
/*   64 */     this.qualitys.addAll(_o_.qualitys);
/*   65 */     this.pettypes = new SetX();
/*   66 */     this.pettypes.addAll(_o_.pettypes);
/*   67 */     this.skillnum = _o_.skillnum;
/*   68 */     this.skillids = new SetX();
/*   69 */     this.skillids.addAll(_o_.skillids);
/*   70 */     this.custtime = _o_.custtime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.qualitys = new SetX();
/*   76 */     this.qualitys.addAll(_o_.qualitys);
/*   77 */     this.pettypes = new SetX();
/*   78 */     this.pettypes.addAll(_o_.pettypes);
/*   79 */     this.skillnum = _o_.skillnum;
/*   80 */     this.skillids = new SetX();
/*   81 */     this.skillids.addAll(_o_.skillids);
/*   82 */     this.custtime = _o_.custtime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.compact_uint32(this.qualitys.size());
/*   90 */     for (Integer _v_ : this.qualitys)
/*      */     {
/*   92 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   94 */     _os_.compact_uint32(this.pettypes.size());
/*   95 */     for (Integer _v_ : this.pettypes)
/*      */     {
/*   97 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   99 */     _os_.marshal(this.skillnum);
/*  100 */     _os_.compact_uint32(this.skillids.size());
/*  101 */     for (Integer _v_ : this.skillids)
/*      */     {
/*  103 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  105 */     _os_.marshal(this.custtime);
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  115 */       int _v_ = 0;
/*  116 */       _v_ = _os_.unmarshal_int();
/*  117 */       this.qualitys.add(Integer.valueOf(_v_));
/*      */     }
/*  119 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  121 */       int _v_ = 0;
/*  122 */       _v_ = _os_.unmarshal_int();
/*  123 */       this.pettypes.add(Integer.valueOf(_v_));
/*      */     }
/*  125 */     this.skillnum = _os_.unmarshal_int();
/*  126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  128 */       int _v_ = 0;
/*  129 */       _v_ = _os_.unmarshal_int();
/*  130 */       this.skillids.add(Integer.valueOf(_v_));
/*      */     }
/*  132 */     this.custtime = _os_.unmarshal_long();
/*  133 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*  140 */     int _size_ = 0;
/*  141 */     for (Integer _v_ : this.qualitys)
/*      */     {
/*  143 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*      */     }
/*  145 */     for (Integer _v_ : this.pettypes)
/*      */     {
/*  147 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(3, this.skillnum);
/*  150 */     for (Integer _v_ : this.skillids)
/*      */     {
/*  152 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(5, this.custtime);
/*  155 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  161 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  164 */       for (Integer _v_ : this.qualitys)
/*      */       {
/*  166 */         _output_.writeInt32(1, _v_.intValue());
/*      */       }
/*  168 */       for (Integer _v_ : this.pettypes)
/*      */       {
/*  170 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  172 */       _output_.writeInt32(3, this.skillnum);
/*  173 */       for (Integer _v_ : this.skillids)
/*      */       {
/*  175 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  177 */       _output_.writeInt64(5, this.custtime);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  183 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  189 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  192 */       boolean done = false;
/*  193 */       while (!done)
/*      */       {
/*  195 */         int tag = _input_.readTag();
/*  196 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  200 */           done = true;
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  205 */           int _v_ = 0;
/*  206 */           _v_ = _input_.readInt32();
/*  207 */           this.qualitys.add(Integer.valueOf(_v_));
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  212 */           int _v_ = 0;
/*  213 */           _v_ = _input_.readInt32();
/*  214 */           this.pettypes.add(Integer.valueOf(_v_));
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  219 */           this.skillnum = _input_.readInt32();
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  224 */           int _v_ = 0;
/*  225 */           _v_ = _input_.readInt32();
/*  226 */           this.skillids.add(Integer.valueOf(_v_));
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  231 */           this.custtime = _input_.readInt64();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  236 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  238 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  247 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  251 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  253 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketPetCon copy()
/*      */   {
/*  259 */     _xdb_verify_unsafe_();
/*  260 */     return new MarketPetCon(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketPetCon toData()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarketPetCon toBean()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return new MarketPetCon(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketPetCon toDataIf()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarketPetCon toBeanIf()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getQualitys()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return xdb.Logs.logSet(new LogKey(this, "qualitys"), this.qualitys);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getQualitysAsData()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*      */     
/*  309 */     MarketPetCon _o_ = this;
/*  310 */     Set<Integer> qualitys = new SetX();
/*  311 */     qualitys.addAll(_o_.qualitys);
/*  312 */     return qualitys;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getPettypes()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return xdb.Logs.logSet(new LogKey(this, "pettypes"), this.pettypes);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getPettypesAsData()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*      */     
/*  328 */     MarketPetCon _o_ = this;
/*  329 */     Set<Integer> pettypes = new SetX();
/*  330 */     pettypes.addAll(_o_.pettypes);
/*  331 */     return pettypes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSkillnum()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return this.skillnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getSkillids()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return xdb.Logs.logSet(new LogKey(this, "skillids"), this.skillids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getSkillidsAsData()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*      */     
/*  355 */     MarketPetCon _o_ = this;
/*  356 */     Set<Integer> skillids = new SetX();
/*  357 */     skillids.addAll(_o_.skillids);
/*  358 */     return skillids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCusttime()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     return this.custtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSkillnum(int _v_)
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*  374 */     xdb.Logs.logIf(new LogKey(this, "skillnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  378 */         new xdb.logs.LogInt(this, MarketPetCon.this.skillnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  382 */             MarketPetCon.this.skillnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  386 */     });
/*  387 */     this.skillnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCusttime(long _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     xdb.Logs.logIf(new LogKey(this, "custtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  399 */         new xdb.logs.LogLong(this, MarketPetCon.this.custtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             MarketPetCon.this.custtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.custtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     MarketPetCon _o_ = null;
/*  416 */     if ((_o1_ instanceof MarketPetCon)) { _o_ = (MarketPetCon)_o1_;
/*  417 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  418 */       return false;
/*  419 */     if (!this.qualitys.equals(_o_.qualitys)) return false;
/*  420 */     if (!this.pettypes.equals(_o_.pettypes)) return false;
/*  421 */     if (this.skillnum != _o_.skillnum) return false;
/*  422 */     if (!this.skillids.equals(_o_.skillids)) return false;
/*  423 */     if (this.custtime != _o_.custtime) return false;
/*  424 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     int _h_ = 0;
/*  432 */     _h_ += this.qualitys.hashCode();
/*  433 */     _h_ += this.pettypes.hashCode();
/*  434 */     _h_ += this.skillnum;
/*  435 */     _h_ += this.skillids.hashCode();
/*  436 */     _h_ = (int)(_h_ + this.custtime);
/*  437 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     StringBuilder _sb_ = new StringBuilder();
/*  445 */     _sb_.append("(");
/*  446 */     _sb_.append(this.qualitys);
/*  447 */     _sb_.append(",");
/*  448 */     _sb_.append(this.pettypes);
/*  449 */     _sb_.append(",");
/*  450 */     _sb_.append(this.skillnum);
/*  451 */     _sb_.append(",");
/*  452 */     _sb_.append(this.skillids);
/*  453 */     _sb_.append(",");
/*  454 */     _sb_.append(this.custtime);
/*  455 */     _sb_.append(")");
/*  456 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  462 */     ListenableBean lb = new ListenableBean();
/*  463 */     lb.add(new ListenableSet().setVarName("qualitys"));
/*  464 */     lb.add(new ListenableSet().setVarName("pettypes"));
/*  465 */     lb.add(new xdb.logs.ListenableChanged().setVarName("skillnum"));
/*  466 */     lb.add(new ListenableSet().setVarName("skillids"));
/*  467 */     lb.add(new xdb.logs.ListenableChanged().setVarName("custtime"));
/*  468 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MarketPetCon {
/*      */     private Const() {}
/*      */     
/*      */     MarketPetCon nThis() {
/*  475 */       return MarketPetCon.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  481 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPetCon copy()
/*      */     {
/*  487 */       return MarketPetCon.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPetCon toData()
/*      */     {
/*  493 */       return MarketPetCon.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MarketPetCon toBean()
/*      */     {
/*  498 */       return MarketPetCon.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPetCon toDataIf()
/*      */     {
/*  504 */       return MarketPetCon.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MarketPetCon toBeanIf()
/*      */     {
/*  509 */       return MarketPetCon.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getQualitys()
/*      */     {
/*  516 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  517 */       return xdb.Consts.constSet(MarketPetCon.this.qualitys);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getQualitysAsData()
/*      */     {
/*  523 */       MarketPetCon.this._xdb_verify_unsafe_();
/*      */       
/*  525 */       MarketPetCon _o_ = MarketPetCon.this;
/*  526 */       Set<Integer> qualitys = new SetX();
/*  527 */       qualitys.addAll(_o_.qualitys);
/*  528 */       return qualitys;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getPettypes()
/*      */     {
/*  535 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  536 */       return xdb.Consts.constSet(MarketPetCon.this.pettypes);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getPettypesAsData()
/*      */     {
/*  542 */       MarketPetCon.this._xdb_verify_unsafe_();
/*      */       
/*  544 */       MarketPetCon _o_ = MarketPetCon.this;
/*  545 */       Set<Integer> pettypes = new SetX();
/*  546 */       pettypes.addAll(_o_.pettypes);
/*  547 */       return pettypes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSkillnum()
/*      */     {
/*  554 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  555 */       return MarketPetCon.this.skillnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSkillids()
/*      */     {
/*  562 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  563 */       return xdb.Consts.constSet(MarketPetCon.this.skillids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getSkillidsAsData()
/*      */     {
/*  569 */       MarketPetCon.this._xdb_verify_unsafe_();
/*      */       
/*  571 */       MarketPetCon _o_ = MarketPetCon.this;
/*  572 */       Set<Integer> skillids = new SetX();
/*  573 */       skillids.addAll(_o_.skillids);
/*  574 */       return skillids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCusttime()
/*      */     {
/*  581 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  582 */       return MarketPetCon.this.custtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSkillnum(int _v_)
/*      */     {
/*  589 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  590 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCusttime(long _v_)
/*      */     {
/*  597 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  598 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  604 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  605 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  611 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  612 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  618 */       return MarketPetCon.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  624 */       return MarketPetCon.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  630 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  631 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  637 */       return MarketPetCon.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  643 */       return MarketPetCon.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  649 */       MarketPetCon.this._xdb_verify_unsafe_();
/*  650 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  656 */       return MarketPetCon.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  662 */       return MarketPetCon.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  668 */       return MarketPetCon.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  674 */       return MarketPetCon.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  680 */       return MarketPetCon.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  686 */       return MarketPetCon.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  692 */       return MarketPetCon.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MarketPetCon
/*      */   {
/*      */     private HashSet<Integer> qualitys;
/*      */     
/*      */     private HashSet<Integer> pettypes;
/*      */     
/*      */     private int skillnum;
/*      */     
/*      */     private HashSet<Integer> skillids;
/*      */     
/*      */     private long custtime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  712 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  717 */       this.qualitys = new HashSet();
/*  718 */       this.pettypes = new HashSet();
/*  719 */       this.skillids = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.MarketPetCon _o1_)
/*      */     {
/*  724 */       if ((_o1_ instanceof MarketPetCon)) { assign((MarketPetCon)_o1_);
/*  725 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  726 */       } else if ((_o1_ instanceof MarketPetCon.Const)) assign(((MarketPetCon.Const)_o1_).nThis()); else {
/*  727 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MarketPetCon _o_) {
/*  732 */       this.qualitys = new HashSet();
/*  733 */       this.qualitys.addAll(_o_.qualitys);
/*  734 */       this.pettypes = new HashSet();
/*  735 */       this.pettypes.addAll(_o_.pettypes);
/*  736 */       this.skillnum = _o_.skillnum;
/*  737 */       this.skillids = new HashSet();
/*  738 */       this.skillids.addAll(_o_.skillids);
/*  739 */       this.custtime = _o_.custtime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  744 */       this.qualitys = new HashSet();
/*  745 */       this.qualitys.addAll(_o_.qualitys);
/*  746 */       this.pettypes = new HashSet();
/*  747 */       this.pettypes.addAll(_o_.pettypes);
/*  748 */       this.skillnum = _o_.skillnum;
/*  749 */       this.skillids = new HashSet();
/*  750 */       this.skillids.addAll(_o_.skillids);
/*  751 */       this.custtime = _o_.custtime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  757 */       _os_.compact_uint32(this.qualitys.size());
/*  758 */       for (Integer _v_ : this.qualitys)
/*      */       {
/*  760 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  762 */       _os_.compact_uint32(this.pettypes.size());
/*  763 */       for (Integer _v_ : this.pettypes)
/*      */       {
/*  765 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  767 */       _os_.marshal(this.skillnum);
/*  768 */       _os_.compact_uint32(this.skillids.size());
/*  769 */       for (Integer _v_ : this.skillids)
/*      */       {
/*  771 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  773 */       _os_.marshal(this.custtime);
/*  774 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  780 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  782 */         int _v_ = 0;
/*  783 */         _v_ = _os_.unmarshal_int();
/*  784 */         this.qualitys.add(Integer.valueOf(_v_));
/*      */       }
/*  786 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  788 */         int _v_ = 0;
/*  789 */         _v_ = _os_.unmarshal_int();
/*  790 */         this.pettypes.add(Integer.valueOf(_v_));
/*      */       }
/*  792 */       this.skillnum = _os_.unmarshal_int();
/*  793 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  795 */         int _v_ = 0;
/*  796 */         _v_ = _os_.unmarshal_int();
/*  797 */         this.skillids.add(Integer.valueOf(_v_));
/*      */       }
/*  799 */       this.custtime = _os_.unmarshal_long();
/*  800 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  806 */       int _size_ = 0;
/*  807 */       for (Integer _v_ : this.qualitys)
/*      */       {
/*  809 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*      */       }
/*  811 */       for (Integer _v_ : this.pettypes)
/*      */       {
/*  813 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  815 */       _size_ += CodedOutputStream.computeInt32Size(3, this.skillnum);
/*  816 */       for (Integer _v_ : this.skillids)
/*      */       {
/*  818 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/*  820 */       _size_ += CodedOutputStream.computeInt64Size(5, this.custtime);
/*  821 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  829 */         for (Integer _v_ : this.qualitys)
/*      */         {
/*  831 */           _output_.writeInt32(1, _v_.intValue());
/*      */         }
/*  833 */         for (Integer _v_ : this.pettypes)
/*      */         {
/*  835 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  837 */         _output_.writeInt32(3, this.skillnum);
/*  838 */         for (Integer _v_ : this.skillids)
/*      */         {
/*  840 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/*  842 */         _output_.writeInt64(5, this.custtime);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  846 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  848 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  856 */         boolean done = false;
/*  857 */         while (!done)
/*      */         {
/*  859 */           int tag = _input_.readTag();
/*  860 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  864 */             done = true;
/*  865 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  869 */             int _v_ = 0;
/*  870 */             _v_ = _input_.readInt32();
/*  871 */             this.qualitys.add(Integer.valueOf(_v_));
/*  872 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  876 */             int _v_ = 0;
/*  877 */             _v_ = _input_.readInt32();
/*  878 */             this.pettypes.add(Integer.valueOf(_v_));
/*  879 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  883 */             this.skillnum = _input_.readInt32();
/*  884 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  888 */             int _v_ = 0;
/*  889 */             _v_ = _input_.readInt32();
/*  890 */             this.skillids.add(Integer.valueOf(_v_));
/*  891 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  895 */             this.custtime = _input_.readInt64();
/*  896 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  900 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  902 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  911 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  915 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  917 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPetCon copy()
/*      */     {
/*  923 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPetCon toData()
/*      */     {
/*  929 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MarketPetCon toBean()
/*      */     {
/*  934 */       return new MarketPetCon(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPetCon toDataIf()
/*      */     {
/*  940 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MarketPetCon toBeanIf()
/*      */     {
/*  945 */       return new MarketPetCon(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  959 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  963 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  967 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  971 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  975 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getQualitys()
/*      */     {
/*  982 */       return this.qualitys;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getQualitysAsData()
/*      */     {
/*  989 */       return this.qualitys;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getPettypes()
/*      */     {
/*  996 */       return this.pettypes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getPettypesAsData()
/*      */     {
/* 1003 */       return this.pettypes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSkillnum()
/*      */     {
/* 1010 */       return this.skillnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSkillids()
/*      */     {
/* 1017 */       return this.skillids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSkillidsAsData()
/*      */     {
/* 1024 */       return this.skillids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCusttime()
/*      */     {
/* 1031 */       return this.custtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSkillnum(int _v_)
/*      */     {
/* 1038 */       this.skillnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCusttime(long _v_)
/*      */     {
/* 1045 */       this.custtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1051 */       if (!(_o1_ instanceof Data)) return false;
/* 1052 */       Data _o_ = (Data)_o1_;
/* 1053 */       if (!this.qualitys.equals(_o_.qualitys)) return false;
/* 1054 */       if (!this.pettypes.equals(_o_.pettypes)) return false;
/* 1055 */       if (this.skillnum != _o_.skillnum) return false;
/* 1056 */       if (!this.skillids.equals(_o_.skillids)) return false;
/* 1057 */       if (this.custtime != _o_.custtime) return false;
/* 1058 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1064 */       int _h_ = 0;
/* 1065 */       _h_ += this.qualitys.hashCode();
/* 1066 */       _h_ += this.pettypes.hashCode();
/* 1067 */       _h_ += this.skillnum;
/* 1068 */       _h_ += this.skillids.hashCode();
/* 1069 */       _h_ = (int)(_h_ + this.custtime);
/* 1070 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1076 */       StringBuilder _sb_ = new StringBuilder();
/* 1077 */       _sb_.append("(");
/* 1078 */       _sb_.append(this.qualitys);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.pettypes);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.skillnum);
/* 1083 */       _sb_.append(",");
/* 1084 */       _sb_.append(this.skillids);
/* 1085 */       _sb_.append(",");
/* 1086 */       _sb_.append(this.custtime);
/* 1087 */       _sb_.append(")");
/* 1088 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketPetCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */