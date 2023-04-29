/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class FightCache extends XBean implements xbean.FightCache
/*      */ {
/*      */   private int role_default_skill;
/*      */   private HashMap<Long, Integer> pet_default_skills;
/*      */   private HashMap<Long, Integer> child_default_skills;
/*      */   private boolean isauto;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.role_default_skill = 0;
/*   25 */     this.pet_default_skills.clear();
/*   26 */     this.child_default_skills.clear();
/*   27 */     this.isauto = false;
/*      */   }
/*      */   
/*      */   FightCache(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.role_default_skill = 0;
/*   34 */     this.pet_default_skills = new HashMap();
/*   35 */     this.child_default_skills = new HashMap();
/*   36 */     this.isauto = false;
/*      */   }
/*      */   
/*      */   public FightCache()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FightCache(FightCache _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FightCache(xbean.FightCache _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof FightCache)) { assign((FightCache)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FightCache _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.role_default_skill = _o_.role_default_skill;
/*   62 */     this.pet_default_skills = new HashMap();
/*   63 */     for (Map.Entry<Long, Integer> _e_ : _o_.pet_default_skills.entrySet())
/*   64 */       this.pet_default_skills.put(_e_.getKey(), _e_.getValue());
/*   65 */     this.child_default_skills = new HashMap();
/*   66 */     for (Map.Entry<Long, Integer> _e_ : _o_.child_default_skills.entrySet())
/*   67 */       this.child_default_skills.put(_e_.getKey(), _e_.getValue());
/*   68 */     this.isauto = _o_.isauto;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.role_default_skill = _o_.role_default_skill;
/*   74 */     this.pet_default_skills = new HashMap();
/*   75 */     for (Map.Entry<Long, Integer> _e_ : _o_.pet_default_skills.entrySet())
/*   76 */       this.pet_default_skills.put(_e_.getKey(), _e_.getValue());
/*   77 */     this.child_default_skills = new HashMap();
/*   78 */     for (Map.Entry<Long, Integer> _e_ : _o_.child_default_skills.entrySet())
/*   79 */       this.child_default_skills.put(_e_.getKey(), _e_.getValue());
/*   80 */     this.isauto = _o_.isauto;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.marshal(this.role_default_skill);
/*   88 */     _os_.compact_uint32(this.pet_default_skills.size());
/*   89 */     for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet())
/*      */     {
/*   91 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   92 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   94 */     _os_.compact_uint32(this.child_default_skills.size());
/*   95 */     for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet())
/*      */     {
/*   97 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   98 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  100 */     _os_.marshal(this.isauto);
/*  101 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  107 */     _xdb_verify_unsafe_();
/*  108 */     this.role_default_skill = _os_.unmarshal_int();
/*      */     
/*  110 */     int size = _os_.uncompact_uint32();
/*  111 */     if (size >= 12)
/*      */     {
/*  113 */       this.pet_default_skills = new HashMap(size * 2);
/*      */     }
/*  115 */     for (; size > 0; size--)
/*      */     {
/*  117 */       long _k_ = 0L;
/*  118 */       _k_ = _os_.unmarshal_long();
/*  119 */       int _v_ = 0;
/*  120 */       _v_ = _os_.unmarshal_int();
/*  121 */       this.pet_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  125 */     int size = _os_.uncompact_uint32();
/*  126 */     if (size >= 12)
/*      */     {
/*  128 */       this.child_default_skills = new HashMap(size * 2);
/*      */     }
/*  130 */     for (; size > 0; size--)
/*      */     {
/*  132 */       long _k_ = 0L;
/*  133 */       _k_ = _os_.unmarshal_long();
/*  134 */       int _v_ = 0;
/*  135 */       _v_ = _os_.unmarshal_int();
/*  136 */       this.child_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  139 */     this.isauto = _os_.unmarshal_boolean();
/*  140 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*  147 */     int _size_ = 0;
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(1, this.role_default_skill);
/*  149 */     for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet())
/*      */     {
/*  151 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  152 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  154 */     for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet())
/*      */     {
/*  156 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  157 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  159 */     _size_ += CodedOutputStream.computeBoolSize(4, this.isauto);
/*  160 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  169 */       _output_.writeInt32(1, this.role_default_skill);
/*  170 */       for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet())
/*      */       {
/*  172 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  173 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  175 */       for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet())
/*      */       {
/*  177 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  178 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  180 */       _output_.writeBool(4, this.isauto);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  184 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  186 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  195 */       boolean done = false;
/*  196 */       while (!done)
/*      */       {
/*  198 */         int tag = _input_.readTag();
/*  199 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  203 */           done = true;
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  208 */           this.role_default_skill = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  213 */           long _k_ = 0L;
/*  214 */           _k_ = _input_.readInt64();
/*  215 */           int readTag = _input_.readTag();
/*  216 */           if (16 != readTag)
/*      */           {
/*  218 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  220 */           int _v_ = 0;
/*  221 */           _v_ = _input_.readInt32();
/*  222 */           this.pet_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  227 */           long _k_ = 0L;
/*  228 */           _k_ = _input_.readInt64();
/*  229 */           int readTag = _input_.readTag();
/*  230 */           if (24 != readTag)
/*      */           {
/*  232 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  234 */           int _v_ = 0;
/*  235 */           _v_ = _input_.readInt32();
/*  236 */           this.child_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  237 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  241 */           this.isauto = _input_.readBool();
/*  242 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  246 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  248 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  257 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  261 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  263 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightCache copy()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new FightCache(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightCache toData()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FightCache toBean()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new FightCache(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightCache toDataIf()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FightCache toBeanIf()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRole_default_skill()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.role_default_skill;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getPet_default_skills()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return xdb.Logs.logMap(new LogKey(this, "pet_default_skills"), this.pet_default_skills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getPet_default_skillsAsData()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*      */     
/*  328 */     FightCache _o_ = this;
/*  329 */     Map<Long, Integer> pet_default_skills = new HashMap();
/*  330 */     for (Map.Entry<Long, Integer> _e_ : _o_.pet_default_skills.entrySet())
/*  331 */       pet_default_skills.put(_e_.getKey(), _e_.getValue());
/*  332 */     return pet_default_skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getChild_default_skills()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return xdb.Logs.logMap(new LogKey(this, "child_default_skills"), this.child_default_skills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getChild_default_skillsAsData()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*      */     
/*  349 */     FightCache _o_ = this;
/*  350 */     Map<Long, Integer> child_default_skills = new HashMap();
/*  351 */     for (Map.Entry<Long, Integer> _e_ : _o_.child_default_skills.entrySet())
/*  352 */       child_default_skills.put(_e_.getKey(), _e_.getValue());
/*  353 */     return child_default_skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsauto()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.isauto;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_default_skill(int _v_)
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     xdb.Logs.logIf(new LogKey(this, "role_default_skill")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  373 */         new xdb.logs.LogInt(this, FightCache.this.role_default_skill)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  377 */             FightCache.this.role_default_skill = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  381 */     });
/*  382 */     this.role_default_skill = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsauto(boolean _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     xdb.Logs.logIf(new LogKey(this, "isauto")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  394 */         new xdb.logs.LogObject(this, Boolean.valueOf(FightCache.this.isauto))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             FightCache.this.isauto = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.isauto = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     FightCache _o_ = null;
/*  411 */     if ((_o1_ instanceof FightCache)) { _o_ = (FightCache)_o1_;
/*  412 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  413 */       return false;
/*  414 */     if (this.role_default_skill != _o_.role_default_skill) return false;
/*  415 */     if (!this.pet_default_skills.equals(_o_.pet_default_skills)) return false;
/*  416 */     if (!this.child_default_skills.equals(_o_.child_default_skills)) return false;
/*  417 */     if (this.isauto != _o_.isauto) return false;
/*  418 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     int _h_ = 0;
/*  426 */     _h_ += this.role_default_skill;
/*  427 */     _h_ += this.pet_default_skills.hashCode();
/*  428 */     _h_ += this.child_default_skills.hashCode();
/*  429 */     _h_ += (this.isauto ? 1231 : 1237);
/*  430 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     StringBuilder _sb_ = new StringBuilder();
/*  438 */     _sb_.append("(");
/*  439 */     _sb_.append(this.role_default_skill);
/*  440 */     _sb_.append(",");
/*  441 */     _sb_.append(this.pet_default_skills);
/*  442 */     _sb_.append(",");
/*  443 */     _sb_.append(this.child_default_skills);
/*  444 */     _sb_.append(",");
/*  445 */     _sb_.append(this.isauto);
/*  446 */     _sb_.append(")");
/*  447 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  453 */     ListenableBean lb = new ListenableBean();
/*  454 */     lb.add(new xdb.logs.ListenableChanged().setVarName("role_default_skill"));
/*  455 */     lb.add(new xdb.logs.ListenableMap().setVarName("pet_default_skills"));
/*  456 */     lb.add(new xdb.logs.ListenableMap().setVarName("child_default_skills"));
/*  457 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isauto"));
/*  458 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FightCache {
/*      */     private Const() {}
/*      */     
/*      */     FightCache nThis() {
/*  465 */       return FightCache.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  471 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightCache copy()
/*      */     {
/*  477 */       return FightCache.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightCache toData()
/*      */     {
/*  483 */       return FightCache.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FightCache toBean()
/*      */     {
/*  488 */       return FightCache.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightCache toDataIf()
/*      */     {
/*  494 */       return FightCache.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FightCache toBeanIf()
/*      */     {
/*  499 */       return FightCache.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRole_default_skill()
/*      */     {
/*  506 */       FightCache.this._xdb_verify_unsafe_();
/*  507 */       return FightCache.this.role_default_skill;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getPet_default_skills()
/*      */     {
/*  514 */       FightCache.this._xdb_verify_unsafe_();
/*  515 */       return xdb.Consts.constMap(FightCache.this.pet_default_skills);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getPet_default_skillsAsData()
/*      */     {
/*  522 */       FightCache.this._xdb_verify_unsafe_();
/*      */       
/*  524 */       FightCache _o_ = FightCache.this;
/*  525 */       Map<Long, Integer> pet_default_skills = new HashMap();
/*  526 */       for (Map.Entry<Long, Integer> _e_ : _o_.pet_default_skills.entrySet())
/*  527 */         pet_default_skills.put(_e_.getKey(), _e_.getValue());
/*  528 */       return pet_default_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getChild_default_skills()
/*      */     {
/*  535 */       FightCache.this._xdb_verify_unsafe_();
/*  536 */       return xdb.Consts.constMap(FightCache.this.child_default_skills);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getChild_default_skillsAsData()
/*      */     {
/*  543 */       FightCache.this._xdb_verify_unsafe_();
/*      */       
/*  545 */       FightCache _o_ = FightCache.this;
/*  546 */       Map<Long, Integer> child_default_skills = new HashMap();
/*  547 */       for (Map.Entry<Long, Integer> _e_ : _o_.child_default_skills.entrySet())
/*  548 */         child_default_skills.put(_e_.getKey(), _e_.getValue());
/*  549 */       return child_default_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsauto()
/*      */     {
/*  556 */       FightCache.this._xdb_verify_unsafe_();
/*  557 */       return FightCache.this.isauto;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_default_skill(int _v_)
/*      */     {
/*  564 */       FightCache.this._xdb_verify_unsafe_();
/*  565 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsauto(boolean _v_)
/*      */     {
/*  572 */       FightCache.this._xdb_verify_unsafe_();
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  579 */       FightCache.this._xdb_verify_unsafe_();
/*  580 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  586 */       FightCache.this._xdb_verify_unsafe_();
/*  587 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  593 */       return FightCache.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  599 */       return FightCache.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  605 */       FightCache.this._xdb_verify_unsafe_();
/*  606 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  612 */       return FightCache.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  618 */       return FightCache.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  624 */       FightCache.this._xdb_verify_unsafe_();
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  631 */       return FightCache.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  637 */       return FightCache.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  643 */       return FightCache.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  649 */       return FightCache.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  655 */       return FightCache.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  661 */       return FightCache.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  667 */       return FightCache.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FightCache
/*      */   {
/*      */     private int role_default_skill;
/*      */     
/*      */     private HashMap<Long, Integer> pet_default_skills;
/*      */     
/*      */     private HashMap<Long, Integer> child_default_skills;
/*      */     
/*      */     private boolean isauto;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  685 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  690 */       this.role_default_skill = 0;
/*  691 */       this.pet_default_skills = new HashMap();
/*  692 */       this.child_default_skills = new HashMap();
/*  693 */       this.isauto = false;
/*      */     }
/*      */     
/*      */     Data(xbean.FightCache _o1_)
/*      */     {
/*  698 */       if ((_o1_ instanceof FightCache)) { assign((FightCache)_o1_);
/*  699 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  700 */       } else if ((_o1_ instanceof FightCache.Const)) assign(((FightCache.Const)_o1_).nThis()); else {
/*  701 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FightCache _o_) {
/*  706 */       this.role_default_skill = _o_.role_default_skill;
/*  707 */       this.pet_default_skills = new HashMap();
/*  708 */       for (Map.Entry<Long, Integer> _e_ : _o_.pet_default_skills.entrySet())
/*  709 */         this.pet_default_skills.put(_e_.getKey(), _e_.getValue());
/*  710 */       this.child_default_skills = new HashMap();
/*  711 */       for (Map.Entry<Long, Integer> _e_ : _o_.child_default_skills.entrySet())
/*  712 */         this.child_default_skills.put(_e_.getKey(), _e_.getValue());
/*  713 */       this.isauto = _o_.isauto;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  718 */       this.role_default_skill = _o_.role_default_skill;
/*  719 */       this.pet_default_skills = new HashMap();
/*  720 */       for (Map.Entry<Long, Integer> _e_ : _o_.pet_default_skills.entrySet())
/*  721 */         this.pet_default_skills.put(_e_.getKey(), _e_.getValue());
/*  722 */       this.child_default_skills = new HashMap();
/*  723 */       for (Map.Entry<Long, Integer> _e_ : _o_.child_default_skills.entrySet())
/*  724 */         this.child_default_skills.put(_e_.getKey(), _e_.getValue());
/*  725 */       this.isauto = _o_.isauto;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  731 */       _os_.marshal(this.role_default_skill);
/*  732 */       _os_.compact_uint32(this.pet_default_skills.size());
/*  733 */       for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet())
/*      */       {
/*  735 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  736 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  738 */       _os_.compact_uint32(this.child_default_skills.size());
/*  739 */       for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet())
/*      */       {
/*  741 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  742 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  744 */       _os_.marshal(this.isauto);
/*  745 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  751 */       this.role_default_skill = _os_.unmarshal_int();
/*      */       
/*  753 */       int size = _os_.uncompact_uint32();
/*  754 */       if (size >= 12)
/*      */       {
/*  756 */         this.pet_default_skills = new HashMap(size * 2);
/*      */       }
/*  758 */       for (; size > 0; size--)
/*      */       {
/*  760 */         long _k_ = 0L;
/*  761 */         _k_ = _os_.unmarshal_long();
/*  762 */         int _v_ = 0;
/*  763 */         _v_ = _os_.unmarshal_int();
/*  764 */         this.pet_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  768 */       int size = _os_.uncompact_uint32();
/*  769 */       if (size >= 12)
/*      */       {
/*  771 */         this.child_default_skills = new HashMap(size * 2);
/*      */       }
/*  773 */       for (; size > 0; size--)
/*      */       {
/*  775 */         long _k_ = 0L;
/*  776 */         _k_ = _os_.unmarshal_long();
/*  777 */         int _v_ = 0;
/*  778 */         _v_ = _os_.unmarshal_int();
/*  779 */         this.child_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  782 */       this.isauto = _os_.unmarshal_boolean();
/*  783 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  789 */       int _size_ = 0;
/*  790 */       _size_ += CodedOutputStream.computeInt32Size(1, this.role_default_skill);
/*  791 */       for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet())
/*      */       {
/*  793 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  794 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  796 */       for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet())
/*      */       {
/*  798 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  799 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  801 */       _size_ += CodedOutputStream.computeBoolSize(4, this.isauto);
/*  802 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  810 */         _output_.writeInt32(1, this.role_default_skill);
/*  811 */         for (Map.Entry<Long, Integer> _e_ : this.pet_default_skills.entrySet())
/*      */         {
/*  813 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  814 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  816 */         for (Map.Entry<Long, Integer> _e_ : this.child_default_skills.entrySet())
/*      */         {
/*  818 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  819 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  821 */         _output_.writeBool(4, this.isauto);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  825 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  827 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  835 */         boolean done = false;
/*  836 */         while (!done)
/*      */         {
/*  838 */           int tag = _input_.readTag();
/*  839 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  843 */             done = true;
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  848 */             this.role_default_skill = _input_.readInt32();
/*  849 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  853 */             long _k_ = 0L;
/*  854 */             _k_ = _input_.readInt64();
/*  855 */             int readTag = _input_.readTag();
/*  856 */             if (16 != readTag)
/*      */             {
/*  858 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  860 */             int _v_ = 0;
/*  861 */             _v_ = _input_.readInt32();
/*  862 */             this.pet_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  863 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  867 */             long _k_ = 0L;
/*  868 */             _k_ = _input_.readInt64();
/*  869 */             int readTag = _input_.readTag();
/*  870 */             if (24 != readTag)
/*      */             {
/*  872 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  874 */             int _v_ = 0;
/*  875 */             _v_ = _input_.readInt32();
/*  876 */             this.child_default_skills.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  877 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  881 */             this.isauto = _input_.readBool();
/*  882 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  886 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  888 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  897 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  901 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  903 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightCache copy()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightCache toData()
/*      */     {
/*  915 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FightCache toBean()
/*      */     {
/*  920 */       return new FightCache(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightCache toDataIf()
/*      */     {
/*  926 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FightCache toBeanIf()
/*      */     {
/*  931 */       return new FightCache(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  953 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  957 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  961 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRole_default_skill()
/*      */     {
/*  968 */       return this.role_default_skill;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getPet_default_skills()
/*      */     {
/*  975 */       return this.pet_default_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getPet_default_skillsAsData()
/*      */     {
/*  982 */       return this.pet_default_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getChild_default_skills()
/*      */     {
/*  989 */       return this.child_default_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getChild_default_skillsAsData()
/*      */     {
/*  996 */       return this.child_default_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsauto()
/*      */     {
/* 1003 */       return this.isauto;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_default_skill(int _v_)
/*      */     {
/* 1010 */       this.role_default_skill = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsauto(boolean _v_)
/*      */     {
/* 1017 */       this.isauto = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1023 */       if (!(_o1_ instanceof Data)) return false;
/* 1024 */       Data _o_ = (Data)_o1_;
/* 1025 */       if (this.role_default_skill != _o_.role_default_skill) return false;
/* 1026 */       if (!this.pet_default_skills.equals(_o_.pet_default_skills)) return false;
/* 1027 */       if (!this.child_default_skills.equals(_o_.child_default_skills)) return false;
/* 1028 */       if (this.isauto != _o_.isauto) return false;
/* 1029 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1035 */       int _h_ = 0;
/* 1036 */       _h_ += this.role_default_skill;
/* 1037 */       _h_ += this.pet_default_skills.hashCode();
/* 1038 */       _h_ += this.child_default_skills.hashCode();
/* 1039 */       _h_ += (this.isauto ? 1231 : 1237);
/* 1040 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1046 */       StringBuilder _sb_ = new StringBuilder();
/* 1047 */       _sb_.append("(");
/* 1048 */       _sb_.append(this.role_default_skill);
/* 1049 */       _sb_.append(",");
/* 1050 */       _sb_.append(this.pet_default_skills);
/* 1051 */       _sb_.append(",");
/* 1052 */       _sb_.append(this.child_default_skills);
/* 1053 */       _sb_.append(",");
/* 1054 */       _sb_.append(this.isauto);
/* 1055 */       _sb_.append(")");
/* 1056 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */